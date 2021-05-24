package com.codeup.tier1hire.repositories;

import com.codeup.tier1hire.models.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationDetailRepo extends JpaRepository<Education, Long> {
}