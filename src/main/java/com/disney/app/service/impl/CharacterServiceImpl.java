package com.disney.app.service.impl;

import com.disney.app.repository.ICharacterDao;
import com.disney.app.domain.Characters;
import com.disney.app.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements ICharacterService {

    @Autowired
    private ICharacterDao charDao;


    @Override
    @Transactional(readOnly = true)
    public Iterable<Characters> findAll() {
        return charDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Characters> findAll(Pageable pageable) {
        return charDao.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Characters> findById(Long id) {
        return charDao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Characters findByName(String name) {
        return charDao.findByName(name);
    }

    @Override
    @Transactional
    public Characters save(Characters characters) {
        return charDao.save(characters);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        charDao.deleteById(id);
    }
}
