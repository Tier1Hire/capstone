package com.codeup.tier1hire.controllers;


import com.codeup.tier1hire.models.Education;
import com.codeup.tier1hire.models.EmploymentDetail;
import com.codeup.tier1hire.models.User;
import com.codeup.tier1hire.repositories.EducationDetailRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

@Controller
public class EducationController {

    private EducationDetailRepo educationDao;

    public EducationController(EducationDetailRepo educationDao) {
        this.educationDao = educationDao;
    }


    @GetMapping("/education-experience")
    public String showEducationForm(Model model) {

        model.addAttribute("education", new Education());
        return "education-experience";
    }

    @PostMapping("/profile/add/education")
    public String addEducationButton() {

        return "redirect:/education-experience";
    }

//    @PostMapping("/education-experience")
//    public String addJobExperienceForm(@ModelAttribute("education") Education education) {
//        educationDao.save(education);
//        return "redirect:/users/profile";
//    }

    @PostMapping("/education-experience")
    public String addEducationExperienceForm(
            @ModelAttribute("education") Education education,
            @RequestParam("educationStartDate") String educationStartDate,
            @RequestParam("educationEndDate") String educationEndDate) throws ParseException {

        education.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(educationStartDate));
        education.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(educationEndDate));
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        education.setUser(user);
        educationDao.save(education);
        return "redirect:/profile";
    }

    @PostMapping("/profile/delete/education/{id}")
    public String deleteEducationExperience(@PathVariable long id) {
        educationDao.deleteById(id);
        return "redirect:/profile";
    }

    @GetMapping("/profile/edit/education/{id}")
    public String editEducationForm(@PathVariable long id, Model model) {

        model.addAttribute("education", educationDao.getOne(id));
        return "/edit-education";
    }

    @PostMapping("/edit/education/{id}")
    public String editEducationChange(
            @PathVariable long id,
            @ModelAttribute("education") Education education,
            @RequestParam("educationStartDate") String educationStartDate,
            @RequestParam("educationEndDate") String educationEndDate) throws ParseException {

        education.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(educationStartDate));
        education.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(educationEndDate));
        System.out.println(educationEndDate);
        Education educationToUpdate = educationDao.getOne(id);
        educationToUpdate.updateContents(education);
        educationDao.save(educationToUpdate);

        return "redirect:/profile";
    }

}
