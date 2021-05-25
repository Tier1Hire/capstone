package com.codeup.tier1hire.repositories;

import com.codeup.tier1hire.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    @Query("FROM User u where u.username LIKE %:term%")
    List<User> getUserByUsername(@Param("term")String term);



}
