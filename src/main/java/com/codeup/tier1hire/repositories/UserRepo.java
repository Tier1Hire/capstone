package com.codeup.tier1hire.repositories;

import com.codeup.tier1hire.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByEmail(String email);
    User findByUsername(String username);
//    List<User> findAllByEducationContaining

    List<User> findAllByFirstNameIsLikeOrLastNameIsLike(String firstName, String lastName);

    @Query("FROM User u JOIN u.educationHistory e WHERE e.school = ?1")
    List<User> findAllByEducation(String school);

    @Query("FROM User u JOIN u.employmentHistory e WHERE e.employer = ?1")
    List<User> findAllByEmployment(String employer);

}
