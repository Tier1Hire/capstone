package com.codeup.tier1hire.controllers;

import com.codeup.tier1hire.models.User;
import com.codeup.tier1hire.repositories.EducationDetailRepo;
import com.codeup.tier1hire.repositories.EmploymentDetailRepo;
import com.codeup.tier1hire.repositories.UserRepo;
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

    @GetMapping("/users/account-signup")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "users/account-signup";
    }

    @PostMapping("/users/account-signup")
    public String saveUser(@ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        usersDao.save(user);
        return "redirect:/users/login";
    }

    @GetMapping("/users/{id}/edit")
    public String updateUser(@PathVariable long id, Model model) {
        User updateUser = usersDao.getOne(id);
        model.addAttribute("users", updateUser);
        return "users/edit";
    }

    @PostMapping("users/edit/{id}")
    public String updateUser(@ModelAttribute User updateUser) {
        usersDao.save(updateUser);
        return "redirect:/profile";
    }

}
