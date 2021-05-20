package com.codeup.tier1hire.repositories;

import com.codeup.tier1hire.models.EmploymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentDetailRepo extends JpaRepository<EmploymentDetail, Long> {
}
