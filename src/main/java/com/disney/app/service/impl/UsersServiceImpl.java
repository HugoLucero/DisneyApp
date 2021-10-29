package com.disney.app.service.impl;

import com.disney.app.domain.Users;
import com.disney.app.repository.IUsersDao;
import com.disney.app.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsersServiceImpl implements IUsersService {

    @Autowired
    private IUsersDao usersDao;

    @Override
    @Transactional(readOnly = true)
    public Optional<Users> findById(Long id) {
        return usersDao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Users findByUsername(String username) {
        return usersDao.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public Users findByEmail(String email) {
        return usersDao.findByEmail(email);
    }

    @Override
    @Transactional
    public Users save(Users users) {
        return usersDao.save(users);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        usersDao.deleteById(id);
    }
}
