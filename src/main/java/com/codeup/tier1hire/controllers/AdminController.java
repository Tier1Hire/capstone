package com.codeup.tier1hire.controllers;

import com.codeup.tier1hire.models.User;
import com.codeup.tier1hire.repositories.UserRepo;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
}
