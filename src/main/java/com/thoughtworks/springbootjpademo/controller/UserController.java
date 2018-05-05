package com.thoughtworks.springbootjpademo.controller;

import com.thoughtworks.springbootjpademo.entity.User;
import com.thoughtworks.springbootjpademo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("users")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping("")
  public String getUserList(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
    Pageable pageable = PageRequest.of(page - 1, 10);
    Page<User> usersPage = userRepository.findAll(pageable);

    model.addAttribute("users", usersPage.getContent());
    return "user/list";
  }

  @GetMapping("/add")
  public String addUser() {
    return "user/add";
  }

  @RequestMapping(value = "/{id}/delete" ,method = RequestMethod.GET)
  public String deleteUser(@PathVariable String id){


    userRepository.deleteById(id);
    return "redirect:/users";
  }

}
