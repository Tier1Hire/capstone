package com.codeup.tier1hire.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class calendarController {

    @GetMapping("/calendar")
    public String calender() {
        return "/calendar";
    }

    @GetMapping("/calendar")
    public String createNew() {
        @event = Event.new
    }
}
