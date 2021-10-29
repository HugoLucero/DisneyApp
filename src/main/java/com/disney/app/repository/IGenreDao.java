package com.disney.app.repository;

import com.disney.app.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGenreDao extends JpaRepository<Genre, Long> {

    public Genre findByName(String name);

}
