package com.codeup.tier1hire.controllers;

import com.codeup.tier1hire.models.EmploymentDetail;
import com.codeup.tier1hire.models.User;
import com.codeup.tier1hire.repositories.EmploymentDetailRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/job-experience")
    public String addJobExperienceForm(
            @ModelAttribute("employment_detail") EmploymentDetail employmentDetail) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        employmentDetail.setUser(user);
        employmentDetailDao.save(employmentDetail);
        return "redirect:/profile";
    }


//    @GetMapping("/job-experience")
//    public String getOneEmployment(Model model) {
//        EmploymentDetail employmentDetail = (EmploymentDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        model.addAttribute("employment_detail", employmentDetail);
//        return "job-experience";
//    }
//
//    @PostMapping("/job-experience")
//    public String updateEmployment(@ModelAttribute("employment_detail") EmploymentDetail employmentDetail) {
//        EmploymentDetail updatedEmployment = employmentDetailDao.findById(employmentDetail.getEmploymentId()).get();
//        updatedEmployment.setEmployer(employmentDetail.getEmployer());
//        updatedEmployment.setAddress1(employmentDetail.getAddress1());
//        updatedEmployment.setAddress2(employmentDetail.getAddress2());
//        updatedEmployment.setPositions(employmentDetail.getPositions());
//        employmentDetailDao.save(updatedEmployment);
//        return "users/profile";
//    }

}
