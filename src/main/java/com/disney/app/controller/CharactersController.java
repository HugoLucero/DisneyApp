package com.disney.app.controller;

import com.disney.app.domain.Characters;
import com.disney.app.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/characters")
public class CharactersController {

    @Autowired
    private ICharacterService characterService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Characters characters){
        return ResponseEntity.status(HttpStatus.CREATED).body(characterService.save(characters));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long idChar){
        Optional<Characters> optionalCharacters = characterService.findById(idChar);
        if (!optionalCharacters.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalCharacters);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Characters charDetails, @PathVariable(value = "id")Long idChar){
        Optional<Characters> optionalCharacters = characterService.findById(idChar);
        if(!optionalCharacters.isPresent()){
            return ResponseEntity.notFound().build();
        }
        optionalCharacters.get().setImage(charDetails.getImage());
        optionalCharacters.get().setName(charDetails.getName());
        optionalCharacters.get().setAge(charDetails.getAge());
        optionalCharacters.get().setWeight(charDetails.getWeight());
        optionalCharacters.get().setHistory(charDetails.getHistory());

        return ResponseEntity.status(HttpStatus.CREATED).body(characterService.save(optionalCharacters.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")Long idChar){
        if(!characterService.findById(idChar).isPresent()){
            return ResponseEntity.notFound().build();
        }
        characterService.deleteById(idChar);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Characters> readAll(){
        return StreamSupport
                .stream(characterService.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
