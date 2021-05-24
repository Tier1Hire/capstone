package com.codeup.tier1hire.repositories;

import com.codeup.tier1hire.models.Interviews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewsRepo extends JpaRepository<Interviews, Long> {
}
