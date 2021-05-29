package com.codeup.tier1hire.controllers;


import com.codeup.tier1hire.repositories.EducationDetailRepo;
import org.springframework.stereotype.Controller;

@Controller
public class EducationController {

    private EducationDetailRepo educationDao;

    public EducationController(EducationDetailRepo educationDao) {
        this.educationDao = educationDao;
    }




}
