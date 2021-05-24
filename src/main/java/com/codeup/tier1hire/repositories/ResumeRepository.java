package com.codeup.tier1hire.repositories;

import com.codeup.tier1hire.models.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
    public List<Resume> findAllByUserId(long userId);
}
