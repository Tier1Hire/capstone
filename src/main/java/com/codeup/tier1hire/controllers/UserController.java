package com.codeup.tier1hire.controllers;

import com.codeup.tier1hire.models.User;
import com.codeup.tier1hire.repositories.EducationDetailRepo;
import com.codeup.tier1hire.repositories.EmploymentDetailRepo;
import com.codeup.tier1hire.repositories.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    private final UserRepo usersDao;
    private final EducationDetailRepo educationDao;
    private final EmploymentDetailRepo employmentDao;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepo usersDao, EducationDetailRepo educationDao, EmploymentDetailRepo employmentDao, PasswordEncoder passwordEncoder) {
        this.usersDao = usersDao;
        this.educationDao = educationDao;
        this.employmentDao = employmentDao;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/index")
    public String getAllUsers(Model model) {

        model.addAttribute("users", usersDao.findAll());

        return "/index";
    }

    @GetMapping("/profile")
    public String getOneUser(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", usersDao.getOne(user.getUserId()));
        return "users/profile";
    }

//    @GetMapping("/users/{userId}/edit")
//    public String updateUser(@PathVariable long userId, Model model) {
//        User updateUser = usersDao.getOne(userId);
//        model.addAttribute("users", updateUser);
//        return "users/edit";
//    }
//
//    @PostMapping("users/edit/{userId}")
//    public String updateUser(@ModelAttribute User updateUser) {
//        usersDao.save(updateUser);
//        return "redirect:/profile";
//    }

    @PostMapping("/profile")
    public String updateUser(@ModelAttribute("user") User user, Model model) {
        User updatedUser = usersDao.findById(user.getUserId()).get();
        updatedUser.setEmail(user.getEmail());
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        usersDao.save(updatedUser);
        return "users/profile";
    }

    @GetMapping("/profile/{id}")
    public String viewProfile(@PathVariable long id, Model model) {
        model.addAttribute("user", usersDao.getOne(id));
        return "/display-profile";
    }

}
