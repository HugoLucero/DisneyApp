package com.disney.app.controller;

import com.disney.app.domain.Movie;
import com.disney.app.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    @Autowired
    private IMovieService movieService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Movie movie){
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.save(movie));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id){
        Optional<Movie> movie = movieService.findById(id);
        if(!movie.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Movie movie, @PathVariable Long id){
        Optional<Movie> optionalMovie = movieService.findById(id);
        if (!optionalMovie.isPresent()){
            return ResponseEntity.notFound().build();
        }
        optionalMovie.get().setImage(movie.getImage());
        optionalMovie.get().setTitle(movie.getTitle());
        optionalMovie.get().setCreationDate(movie.getCreationDate());
        optionalMovie.get().setQualification(movie.getQualification());
        optionalMovie.get().setCharacters(movie.getCharacters());

        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.save(optionalMovie.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Movie> movie = movieService.findById(id);
        if (!movie.isPresent()){
            return ResponseEntity.notFound().build();
        }
        movieService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Movie> movies(){
        return StreamSupport
                .stream(movieService.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
