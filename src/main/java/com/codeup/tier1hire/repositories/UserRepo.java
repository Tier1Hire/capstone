package com.codeup.tier1hire.repositories;

import com.codeup.tier1hire.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByEmail(String email);
    User findByUsername(String username);
    User findByIsAdmin(boolean isAdmin);
//    List<User> findAllByEducationContaining

//    List<User> findAllByFirstNameIsLikeOrLastNameIsLike(String firstName, String lastName);

//    @Query("FROM User u JOIN u.educationHistory ed JOIN u.employmentHistory e WHERE u.firstName LIKE %?1% OR u.lastName LIKE %?1% OR ed.school LIKE %?1% OR e.employer LIKE %?1%")
//    List<User> search(String keyword);

    @Query("SELECT DISTINCT u FROM User u JOIN u.educationHistory ed JOIN u.employmentHistory e WHERE u.firstName LIKE %?1% OR u.lastName LIKE %?1% OR ed.school LIKE %?1% OR e.employer LIKE %?1% ORDER BY u.isVerified")
    List<User> search(String keyword);

    @Query("FROM User u WHERE u.firstName LIKE %?1% OR u.lastName LIKE %?1%")
    List<User> findAllByFirstNameIsLikeOrLastNameIsLike(String name);

    @Query("FROM User u JOIN u.educationHistory e WHERE e.school = ?1")
    List<User> findAllByEducation(String school);

    @Query("FROM User u JOIN u.employmentHistory e WHERE e.employer = ?1")
    List<User> findAllByEmployment(String employer);

}
