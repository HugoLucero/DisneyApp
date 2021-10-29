package com.disney.app.service;

import com.disney.app.domain.Users;

import java.util.Optional;

public interface IUsersService {

    public Optional<Users> findById(Long id);

    public Users findByUsername(String username);

    public Users findByEmail(String email);

    public Users save(Users users);

    public void deleteById(Long id);
}
