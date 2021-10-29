package com.disney.app.repository;

import com.disney.app.domain.Characters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICharacterDao extends JpaRepository<Characters, Long> {

    public Characters findByName(String name);

}
