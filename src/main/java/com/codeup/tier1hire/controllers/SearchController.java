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

    @PostMapping("/search/")
    public String search(@Param("keyword") String keyword, Model model) {

        if (keyword == null) {
            return "index";
        }

        model.addAttribute("keyword", keyword);
        model.addAttribute("users", usersDao.search(keyword));
        return "search-results";
    }

}
