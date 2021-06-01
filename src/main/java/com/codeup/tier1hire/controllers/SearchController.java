package com.codeup.tier1hire.controllers;

import com.codeup.tier1hire.models.User;
import com.codeup.tier1hire.repositories.UserRepo;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchController {

    private final UserRepo usersDao;

    public SearchController(UserRepo usersDao) {
        this.usersDao = usersDao;
    }

//    @GetMapping("search/{keyword}")
//    public String searchResults(@PathVariable String keyword, Model model) {
//
//        model.addAttribute("users", usersDao.search(keyword));
//        return "search-results";
//    }

    @PostMapping("/search")
    public String search(@Param("keyword") String keyword, Model model) {

        model.addAttribute("keyword", keyword);
        model.addAttribute("users", usersDao.search(keyword));
        return "search-results";
    }


    //    // Must make separate views for results as using same seems to throw "ambiguous error"
//    @GetMapping("/search/{name}")
//    public String searchByName(@PathVariable String name, Model model) {
//
//        model.addAttribute("users", usersDao.findAllByFirstNameIsLikeOrLastNameIsLike(name, name));
////        model.addAttribute("users", usersDao.findAllByEducation(name));
////        model.addAttribute("users", usersDao.findAllByEmployment(name));
//        return "/search-results";
//    }

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
