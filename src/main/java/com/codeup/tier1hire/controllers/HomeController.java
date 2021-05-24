package com.codeup.tier1hire.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/")
  public String root() {
    return "index";
  }

  @GetMapping("/user")
  public String userIndex() {
    return "user/index";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }


}
