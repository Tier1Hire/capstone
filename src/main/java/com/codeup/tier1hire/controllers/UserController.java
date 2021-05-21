package com.codeup.tier1hire.controllers;

import com.codeup.tier1hire.models.User;
import com.codeup.tier1hire.repositories.EducationDetailRepo;
import com.codeup.tier1hire.repositories.EmploymentDetailRepo;
import com.codeup.tier1hire.repositories.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    private final UserRepo usersDao;
    private final EducationDetailRepo educationDao;
    private final EmploymentDetailRepo employmentDao;

    public UserController(UserRepo usersDao, EducationDetailRepo educationDao, EmploymentDetailRepo employmentDao) {
        this.usersDao = usersDao;
        this.educationDao = educationDao;
        this.employmentDao = employmentDao;
    }

    @GetMapping("/users")
    @ResponseBody
    public List<User> getAllUsers() {
        return usersDao.findAll();
    }

    @GetMapping("/users/{id}")
    public String getOneUser(@PathVariable long id, Model model) {
        User user = usersDao.getOne(id);
        model.addAttribute("user", user);
        return "/profile";
    }

    @GetMapping("users/register")
    public String createUser(@ModelAttribute User user) {
        usersDao.save(user);
        return "/profile";
    }

    @GetMapping("users/{id}/edit")
    public String updateUser(@PathVariable long id, Model model) {
        User updateUser = usersDao.getOne(id);
        model.addAttribute("users", updateUser);
        return "users/edit";
    }

    @PostMapping("users/edit/{id}")
    public String updateUser(@ModelAttribute User user) {
        usersDao.save(user);
        return "redirect:/profile";
    }



}
