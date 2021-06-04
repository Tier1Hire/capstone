package com.codeup.tier1hire.repositories;

import com.codeup.tier1hire.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByEmail(String email);
    User findByUsername(String username);
    User findByIsAdmin(boolean isAdmin);

    @Query("SELECT DISTINCT u FROM User u JOIN u.educationHistory ed JOIN u.employmentHistory e WHERE u.firstName LIKE %?1% OR u.lastName LIKE %?1% OR ed.school LIKE %?1% OR e.employer LIKE %?1% ORDER BY u.isVerified DESC")
    List<User> search(String keyword);


}
