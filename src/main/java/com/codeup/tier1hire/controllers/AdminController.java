package com.codeup.tier1hire.controllers;

import com.codeup.tier1hire.models.User;
import com.codeup.tier1hire.repositories.UserRepo;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    private UserRepo userDao;

    public AdminController(UserRepo userDao) {
        this.userDao = userDao;
    }

//    @GetMapping("/profile/{id}")
//    public String viewProfile(@PathVariable long id, Model model) {
//        model.addAttribute("user", userDao.getOne(id));
//        return "/profile";
//    }

    @PostMapping("/profile/admin/{id}")
    public String adminButton(@PathVariable long id) {

        User userEdit = userDao.getOne(id);
        if (userEdit.isAdmin()) {
            userEdit.setAdmin(false);
        } else {
            userEdit.setAdmin(true);
        }
        userDao.save(userEdit);
        return "redirect:/profile/" + id;
    }

    @PostMapping("/profile/verify/{id}")
    public String verifyButton(@PathVariable long id) {

        User userEdit = userDao.getOne(id);
        if (userEdit.isVerified()) {
            userEdit.setVerified(false);
        } else {
            userEdit.setVerified(true);
        }
        userDao.save(userEdit);
        return "redirect:/profile/" + id;
    }

    @PostMapping("/profile/delete//{id}")
    public String deleteJobExperience(@PathVariable long id) {

        userDao.deleteById(id);

        return "redirect:/profile";
    }

}
