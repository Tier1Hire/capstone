package com.codeup.tier1hire.repositories;

import com.codeup.tier1hire.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.firstName like %:term%")
    List<User> getUserByFirstName(@Param("term") String term);

    @Query("SELECT u FROM User u WHERE u.firstName like %:term%")
    List<User> getUserByLastName(@Param("term") String term);
}
