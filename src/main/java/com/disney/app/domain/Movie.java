package com.disney.app.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "movie")

public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movie")
    private Long idMovie;

    private String image;

    private String title;

    @Column(name = "creation_date")
    private String creationDate;

    @Min(value = 1)
    @Max(value = 5)
    private Integer qualification;

    @ManyToMany
    @JoinTable(
            name = "characters_like",
            joinColumns = @JoinColumn(name = "movies_id"),
            inverseJoinColumns = @JoinColumn(name = "characters_id")
    )
    private List<Characters> characters;

    public Movie(Long idMovie){
        this.idMovie = idMovie;
    }

    public Movie(Long idMovie, String image, String title, String creationDate, Integer qualification, List<Characters> characters) {
        this.idMovie = idMovie;
        this.image = image;
        this.title = title;
        this.creationDate = creationDate;
        this.qualification = qualification;
        this.characters = characters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Movie movie = (Movie) o;
        return idMovie != null && Objects.equals(idMovie, movie.idMovie);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
