package com.codeup.tier1hire.controllers;

import com.codeup.tier1hire.models.EmploymentDetail;
import com.codeup.tier1hire.models.User;
import com.codeup.tier1hire.repositories.EmploymentDetailRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class JobExperienceController {

    private EmploymentDetailRepo employmentDetailDao;

    public JobExperienceController(EmploymentDetailRepo employmentDetailDao) {
        this.employmentDetailDao = employmentDetailDao;
    }

    @GetMapping("/job-experience")
    public String showJobExperienceForm(Model model) {
        model.addAttribute("job", new EmploymentDetail());
        return "job-experience";
    }

    @PostMapping("/profile/add/job")
    public String addJobButton() {

        return "redirect:/job-experience";
    }


    @PostMapping("/job-experience")
    public String addJobExperienceForm(
            @ModelAttribute("employment_detail") EmploymentDetail employmentDetail,
            @RequestParam("jobStartDate") String jobStartDate,
            @RequestParam("jobEndDate") String jobEndDate) throws ParseException {
        employmentDetail.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(jobStartDate));
        employmentDetail.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(jobEndDate));
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        employmentDetail.setUser(user);
        employmentDetailDao.save(employmentDetail);
        return "redirect:/profile";
    }

    @PostMapping("/profile/delete/job/{id}")
    public String deleteJobExperience(@PathVariable long id) {

        employmentDetailDao.deleteById(id);

        return "redirect:/profile";
    }

    @GetMapping("/profile/edit/job/{id}")
    public String editJobForm(@PathVariable long id, Model model) {

        model.addAttribute("job", employmentDetailDao.getOne(id));
        return "edit-job";
    }

    @PostMapping("/edit/job/{id}")
    public String editJobChange(@PathVariable long id,
                                @ModelAttribute("job") EmploymentDetail employmentDetail,
                                @RequestParam("jobStartDate") String jobStartDate,
                                @RequestParam("jobEndDate") String jobEndDate) throws ParseException {
        employmentDetail.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(jobStartDate));
        employmentDetail.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(jobEndDate));

        EmploymentDetail employmentDetailToUpdate = employmentDetailDao.getOne(id);
        employmentDetailToUpdate.updateContents(employmentDetail);
        employmentDetailDao.save(employmentDetailToUpdate);

        return "redirect:/profile";
    }

}
