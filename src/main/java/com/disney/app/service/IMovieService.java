package com.disney.app.service;

import com.disney.app.domain.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface IMovieService {

    public Iterable<Movie> findAll();

    public Page<Movie> findAll(Pageable pageable);

    public Optional<Movie> findById(Long id);

    public Movie findByTitle(String title);

    public Movie save(Movie movie);

    public void deleteById(Long id);
}
