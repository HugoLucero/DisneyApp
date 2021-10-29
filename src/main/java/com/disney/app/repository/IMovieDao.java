package com.disney.app.repository;

import com.disney.app.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieDao extends JpaRepository<Movie, Long> {

    public Movie findByTitle(String name);

}
