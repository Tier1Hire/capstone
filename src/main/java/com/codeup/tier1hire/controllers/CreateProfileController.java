package com.codeup.tier1hire.controllers;
  import com.codeup.tier1hire.repositories.NewProfileRepo;
  import org.springframework.boot.SpringApplication;
  import org.springframework.boot.autoconfigure.SpringBootApplication;
  import org.springframework.core.env.Profiles;
  import org.springframework.stereotype.Controller;
  import org.springframework.ui.Model;
  import org.springframework.web.bind.annotation.*;

  import java.io.File;
  import java.util.ArrayList;
  import java.util.List;

@Controller
public class CreateProfileController {


  private final NewProfileRepo postDao;

  public CreateProfileController(NewProfileRepo postDao){
    this.postDao = postDao;
  }

  @GetMapping("/createProfile")
  public String allPosts(Model model){

    model.addAttribute("profile", postDao.findAll());
    return "posts/index";
  }

  @GetMapping("profiles/search")
  public String searchPosts(@RequestParam(name = "term") String term, Model viewModel){
    term = "%"+term+"%";
    List<Profiles> dbPosts = postDao.findAllByTitleIsLike(term);
    viewModel.addAttribute("posts", dbPosts);
    return "posts/index";
  }

  @GetMapping("/profiles/{id}")
  public String viewSelectedPost(@PathVariable long id, Model model){

    model.addAttribute("selectedPost", postDao.getOne(id));
    return "posts/show";
  }

  @GetMapping("/profile/create")
  public String createNewPost(Model model){
    return "posts/new";
  }

  @PostMapping("/profile/create")
  public String savingNewPost(@ModelAttribute Post post){
    postDao.save(post);
    return "redirect:/posts/" + post.getId();
  }

  @GetMapping("/profile/delete/{id}")
  public String deletePost(@PathVariable long id){
    Post post = postDao.getOne(id);
    postDao.delete(post);
    return "redirect:/posts";
  }

  @GetMapping("/profile/edit/{id}")
  public String editAd(@PathVariable long id, Model model) {
    Post post = postDao.getOne(id);
    model.addAttribute("post", post);
    return "posts/create";
  }

  @PostMapping("/profile/edit")
  public String updateAd(@ModelAttribute Post post) {
    postDao.save(post);
    return "redirect:/posts/" + post.getId();
  }
}
