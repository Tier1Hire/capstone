package com.codeup.tier1hire.controllers;

import com.codeup.tier1hire.repositories.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SearchController {

    private final UserRepo usersDao;

    public SearchController(UserRepo usersDao) {
        this.usersDao = usersDao;
    }

    //    // Must make separate views for results as using same seems to throw "ambiguous error"
    @GetMapping("/search/{name}")
    public String searchByName(@PathVariable String name, Model model) {

        model.addAttribute("users", usersDao.findAllByFirstNameIsLikeOrLastNameIsLike(name, name));
//        model.addAttribute("users", usersDao.findAllByEducation(name));
//        model.addAttribute("users", usersDao.findAllByEmployment(name));
        return "/search-results";
    }

//    @GetMapping("/search-results/{school}")
//    public String searchBySchool(@PathVariable String school, Model model) {
//
//        model.addAttribute("users", usersDao.findAllByEducation(school));
//        return "/search-results";
//    }

//    @GetMapping("/search-results/{employer}")
//    public String searchBySchool(@PathVariable String employer, Model model) {
//
//        model.addAttribute("users", usersDao.findAllByEmployment(employer));
//        return "/search-results";
//    }
}
