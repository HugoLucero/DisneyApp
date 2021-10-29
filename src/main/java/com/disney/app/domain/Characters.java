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
@Table(name = "characters")

public class Characters implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_character")
	private Long idCharacter;
	
	private String image;
	
	private String name;
	
	private Integer age;
	
	private Float weight;
	
	private String history;

	@ManyToMany(mappedBy = "characters")
	private List<Movie> movies;

	public Characters(Long idCharacter) {
		this.idCharacter = idCharacter;
	}

	public Characters(Long idCharacter, String image, String name, Integer age, Float weight, String history, List<Movie> movies) {
		this.idCharacter = idCharacter;
		this.image = image;
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.history = history;
		this.movies = movies;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Characters characters = (Characters) o;
		return idCharacter != null && Objects.equals(idCharacter, characters.idCharacter);
	}

	@Override
	public int hashCode() {
		return 0;
	}
}
