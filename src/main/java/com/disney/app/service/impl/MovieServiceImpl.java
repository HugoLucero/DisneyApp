package com.disney.app.service.impl;

import com.disney.app.repository.IMovieDao;
import com.disney.app.domain.Movie;
import com.disney.app.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements IMovieService {

    @Autowired
    private IMovieDao movieDao;


    @Override
    @Transactional(readOnly = true)
    public Iterable<Movie> findAll() {
        return movieDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Movie> findAll(Pageable pageable) {
        return movieDao.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Movie> findById(Long id) {
        return movieDao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Movie findByTitle(String title) {
        return movieDao.findByTitle(title);
    }

    @Override
    @Transactional
    public Movie save(Movie movie) {
        return movieDao.save(movie);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        movieDao.deleteById(id);
    }
}
