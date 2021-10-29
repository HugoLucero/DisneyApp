package com.disney.app.controller;

import com.disney.app.domain.Users;
import com.disney.app.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class UsersController {

    @Autowired
    private IUsersService usersService;

    @PostMapping("/register")
    public ResponseEntity<?> create(@RequestBody Users users){
        return ResponseEntity.status(HttpStatus.CREATED).body(usersService.save(users));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id){
        Optional<Users> users = usersService.findById(id);
        if (!users.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Users users, @PathVariable Long id){
        Optional<Users> oUsers = usersService.findById(id);
        if (!oUsers.isPresent()){
            return ResponseEntity.notFound().build();
        }
        oUsers.get().setPassword(users.getPassword());
        oUsers.get().setName(users.getName());
        oUsers.get().setLastname(users.getLastname());
        oUsers.get().setEnabled(users.getEnabled());

        return ResponseEntity.status(HttpStatus.CREATED).body(usersService.save(oUsers.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Users> users = usersService.findById(id);
        if (!users.isPresent()){
            return ResponseEntity.notFound().build();
        }
        usersService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
