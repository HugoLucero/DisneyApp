package com.disney.app.auth.service;

import java.util.ArrayList;
import java.util.Collections;

//import com.disney.app.auth.config.MyUserDetails;
import com.disney.app.domain.Users;
import com.disney.app.repository.IUsersDao;
import com.disney.app.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsCustomService implements UserDetailsService{

    @Autowired
    private IUsersService usersService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = usersService.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("User: " + username + " does not exist.");
        }

        return new User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }
    
   

}
