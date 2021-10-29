package com.disney.app.auth.controller;

import com.disney.app.auth.service.EncriptPassword;
import com.disney.app.domain.Users;
import com.disney.app.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private IUsersService usersService;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody Users users){
        users.setPassword(EncriptPassword.encriptPassword(users.getPassword()));
        return ResponseEntity.status(HttpStatus.CREATED).body(usersService.save(users));
    }
}
