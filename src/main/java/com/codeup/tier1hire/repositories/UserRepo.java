package com.codeup.tier1hire.repositories;

import com.codeup.tier1hire.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    @Query("select u from User u where u.username = ?1")
    User findByUsername(String username);

    List<User> findAllByFirstNameIsLikeOrLastNameIsLike(String firstName, String lastName);

//    @Query("FROM User u WHERE u.firstName LIKE ?1")
//    List<User> getUserByFirstName(String firstName);
//
//    @Query("FROM User u WHERE u.lastName LIKE ?1")
//    List<User> getUserByLastName(String lastName);




}
