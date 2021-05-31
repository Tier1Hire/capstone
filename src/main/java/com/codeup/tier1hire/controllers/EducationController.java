package com.codeup.tier1hire.controllers;


import com.codeup.tier1hire.models.Education;
import com.codeup.tier1hire.models.EmploymentDetail;
import com.codeup.tier1hire.models.User;
import com.codeup.tier1hire.repositories.EducationDetailRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

        return "education-experience";
    }

//    @PostMapping("/education-experience")
//    public String addJobExperienceForm(@ModelAttribute("education") Education education) {
//        educationDao.save(education);
//        return "redirect:/users/profile";
//    }

    @PostMapping("/education-experience")
    public String addJobExperienceForm(@ModelAttribute("education") Education education) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        education.setUser(user);
        educationDao.save(education);
        return "redirect:/profile";
    }

    @PostMapping("/profile/delete/education/{id}")
    public String deleteJobExperience(@PathVariable long id) {
        educationDao.deleteById(id);
        return "redirect:/profile";
    }


}
