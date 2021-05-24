package com.codeup.tier1hire.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "/hello";
    }

}