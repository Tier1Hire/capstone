package com.codeup.tier1hire.repositories;

import com.codeup.tier1hire.models.Education;
import com.codeup.tier1hire.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationDetailRepo extends JpaRepository<Education, Long> {


    List<Education> findByUser(User user);
}
