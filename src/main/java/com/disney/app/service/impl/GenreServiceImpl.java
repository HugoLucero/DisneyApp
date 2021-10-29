package com.disney.app.service.impl;

import com.disney.app.repository.IGenreDao;
import com.disney.app.domain.Genre;
import com.disney.app.service.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements IGenreService {

    @Autowired
    private IGenreDao genreDao;


    @Override
    @Transactional(readOnly = true)
    public Iterable<Genre> findAll() {
        return genreDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Genre> findById(Long id) {
        return genreDao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Genre findByName(String name) {
        return genreDao.findByName(name);
    }

    @Override
    @Transactional
    public Genre save(Genre genre) {
        return genreDao.save(genre);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        genreDao.deleteById(id);
    }
}
