package com.disney.app.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "genre")

public class Genre implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genre")
    private Long idGenre;

    private String name;

    private String image;

    @OneToMany
    @JoinColumn(name = "movies")
    @ToString.Exclude
    private List<Movie> movies;

    public Genre(Long idGenre) {
        this.idGenre = idGenre;
    }

    public Genre(Long idGenre, String name, String image, List<Movie> movies) {
        this.idGenre = idGenre;
        this.name = name;
        this.image = image;
        this.movies = movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Genre genre = (Genre) o;
        return idGenre != null && Objects.equals(idGenre, genre.idGenre);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
