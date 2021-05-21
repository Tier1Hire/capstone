package com.codeup.tier1hire.controllers;
  import com.codeup.tier1hire.repositories.NewProfileRepo;
  import org.apache.tomcat.jni.User;
  import org.springframework.core.env.Profiles;
  import org.springframework.stereotype.Controller;
  import org.springframework.ui.Model;
  import org.springframework.web.bind.annotation.*;

  import java.util.List;

@Controller
public class CreateProfileController {


  private final NewProfileRepo userDao;

  public CreateProfileController(NewProfileRepo userDao){
    this.userDao = userDao;
  }

  @GetMapping("/createProfile")
  public String allPosts(Model model){

    model.addAttribute("profile", userDao.findAll());
    return "posts/index";
  }

  @GetMapping("profiles/search")
  public String searchPosts(@RequestParam(name = "term") String term, Model viewModel){
    term = "%"+term+"%";
    List<Profiles> dbPosts = userDao.findAllByTitleIsLike(term);
    viewModel.addAttribute("posts", dbPosts);
    return "redirect:/profile";
  }

  @GetMapping("/profiles/{id}")
  public String viewSelectedPost(@PathVariable long id, Model model){

    model.addAttribute("selectedPost", userDao.getOne(id));
    return "redirect:/profile";
  }

  @GetMapping("/profile/create")
  public String createNewPost(Model model){
    return "profile/new";
  }

  @PostMapping("/profile/create")
  public String savingNewPost(@ModelAttribute User user){
    userDao.save(user);
    return "redirect:/profile/" + user.getId();
  }

  @GetMapping("/profile/delete/{id}")
  public String deletePost(@PathVariable long id){
    User userDao = user.getOne(id);
    userDao.delete(userDao);
    return "redirect:/profile";
  }
  @GetMapping("/profile/{id}/edit")
  public String updateProfile(@PathVariable long id, Model model ){
    User updateUser = (User) userDao.getOne(id);
    model.addAttribute ("profile",updateUser);
    return "profile/edit";
  }

  @PostMapping("/profile/edit")
  public String updateUser(@ModelAttribute User user) {
    userDao.save(user);
    return "redirect:/profile" + user.getId();
  }
}
