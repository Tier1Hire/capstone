package com.codeup.tier1hire.repositories;

import com.codeup.tier1hire.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);

}