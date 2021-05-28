//package com.codeup.tier1hire.controllers;
//
//import com.codeup.tier1hire.models.Resume;
//import com.codeup.tier1hire.repositories.ResumeRepository;
//import com.codeup.tier1hire.services.UserService;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Date;
//
//@Controller
//public class ResumeUploadController {
//
//    @Value("${file-upload-path}")
//    private String uploadPath;
//
//    private final ResumeRepository resumeDao;
//    private final UserService userService;
//
//    public ResumeUploadController(ResumeRepository resumeDao, UserService userService) {
//        this.resumeDao = resumeDao;
//        this.userService = userService;
//    }
//
//    @PostMapping("/fileUpload")
//    public String saveFile(Model model, @RequestParam(name = "file") MultipartFile uploadFile, @ModelAttribute Resume resume) {
//        String filename = uploadFile.getOriginalFilename();
//        String filepath = Paths.get(uploadPath, filename).toString();
//        File destinationFile = new File(filepath);
//        resume.setCreatedAt(new Date(System.currentTimeMillis()));
//        resume.setFilePath(filepath);
//        resume.setUser(userService.loggedInUser());
//        try {
//            uploadFile.transferTo(destinationFile);
//            resumeDao.save(resume);
//            model.addAttribute("message", "Success");
//        } catch (IOException e) {
//            e.printStackTrace();
//            model.addAttribute("message", "Failed" + e);
//        }
//        return "redirect:/profile";
//    }
//
//    @PostMapping("/resume/{id}")
//    public String deleteResume(@PathVariable long id) {
//        Resume r = resumeDao.getOne(id);
//        Path p = Paths.get(r.getFilePath());
//        try {
//            Files.deleteIfExists(p);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        resumeDao.deleteById(id);
//        return "redirect:/profile";
//    }
//
//}