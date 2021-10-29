package com.disney.app.service;

import com.disney.app.domain.Genre;

import java.util.Optional;


public interface IGenreService {

    public Iterable<Genre> findAll();

    public Optional<Genre> findById(Long id);

    public Genre findByName(String name);

    public Genre save(Genre genre);

    public void deleteById(Long id);
}
