package com.disney.app.repository;

import com.disney.app.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsersDao extends JpaRepository<Users, Long> {

    public Users findByUsername(String username);

    public Users findByEmail(String email);
}
