package com.disney.app.service;

import com.disney.app.domain.Characters;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICharacterService {

    public Iterable<Characters> findAll();
    public Page<Characters> findAll(Pageable pageable);
    public Optional<Characters> findById(Long id);
    public Characters findByName(String name);
    public Characters save(Characters characters);
    public void deleteById(Long id);
}
