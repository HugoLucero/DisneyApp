package com.disney.app.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "users")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_users")
    private Long idUsers;

    @Column(name = "username", unique = true, updatable = false)
    private String username;

    private String password;

    @Email
    @Column(unique = true)
    private String email;

    private Boolean enabled;

    private String name;

    private String lastname;

    public Users(Long idUsers) {
        this.idUsers = idUsers;
    }

    public Users(Long idUsers, String username, String password, String email, Boolean enabled, String name, String lastname) {
        this.idUsers = idUsers;
        this.username = username;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
        this.name = name;
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Users users = (Users) o;
        return idUsers != null && Objects.equals(idUsers, users.idUsers);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
