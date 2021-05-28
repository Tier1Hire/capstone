package com.codeup.tier1hire.controllers;

import com.codeup.tier1hire.models.EmploymentDetail;
import com.codeup.tier1hire.repositories.EmploymentDetailRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobExperienceController {

    private EmploymentDetailRepo employmentDetailDao;

    public JobExperienceController(EmploymentDetailRepo employmentDetailDao) {
        this.employmentDetailDao = employmentDetailDao;
    }

    @GetMapping("/job-experience")
    public String showJobExperienceForm(Model model) {
        model.addAttribute("employment_detail", new EmploymentDetail());
        return "job-experience";
    }
}
