package com.disney.app.auth.controller;

import com.disney.app.auth.dto.AuthenticationRequest;
import com.disney.app.auth.dto.AuthenticationResponse;
import com.disney.app.auth.service.JwtService;
import com.disney.app.auth.service.UserDetailsCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {


    private final AuthenticationManager authenticationManager;
    private final UserDetailsCustomService userDetailsCustomService;
    private final JwtService jwtService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, UserDetailsCustomService userDetailsCustomService, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsCustomService = userDetailsCustomService;
        this.jwtService = jwtService;
    }

    @PostMapping
    public ResponseEntity<?> createToken(@RequestBody AuthenticationRequest authenticationRequest) throws BadCredentialsException {
        try {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword());
            authenticationManager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Invalid username or password", e.getCause());
        }
        UserDetails userDetails = userDetailsCustomService.loadUserByUsername(authenticationRequest.getUsername());
        String token = jwtService.createToken(userDetails);
        return ResponseEntity.ok(token);
    }
}
