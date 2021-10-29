package com.disney.app.controller;

import com.disney.app.domain.Genre;
import com.disney.app.service.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    private IGenreService genreService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Genre genre){
        return ResponseEntity.status(HttpStatus.CREATED).body(genreService.save(genre));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id){
        Optional<Genre> genre = genreService.findById(id);
        if(!genre.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(genre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Genre genre, @PathVariable Long id){
        Optional<Genre> oGenre = genreService.findById(id);
        if(!oGenre.isPresent()){
            return ResponseEntity.notFound().build();
        }
        oGenre.get().setName(genre.getName());
        oGenre.get().setImage(genre.getImage());
        oGenre.get().setMovies(genre.getMovies());

        return ResponseEntity.status(HttpStatus.CREATED).body(genreService.save(oGenre.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Genre> genre = genreService.findById(id);
        if(!genre.isPresent()){
            return ResponseEntity.notFound().build();
        }
        genreService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Genre> readAll(){
        return StreamSupport
                .stream(genreService.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }


}
