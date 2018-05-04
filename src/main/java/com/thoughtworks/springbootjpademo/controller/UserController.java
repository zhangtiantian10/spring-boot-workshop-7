package com.thoughtworks.springbootjpademo.controller;

import com.thoughtworks.springbootjpademo.entity.User;
import com.thoughtworks.springbootjpademo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping()
    public String list(Model model) {
        List<User> userList = userRepository.findAll();
        model.addAttribute("userList", userList);
        return "user/list";
    }

    @GetMapping("add")
    public String toAdd() {
        return "user/add";
    }

    @PostMapping("add")
    public String add(User user) {
        userRepository.save(user);
        return "redirect:/users";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable String id) {
        userRepository.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("{id}/edit")
    public String toEdit(@PathVariable String id, Model model) {
        User user = userRepository.findById(id).get();
        model.addAttribute("user", user);
        return "user/edit";
    }

    @PostMapping("edit")
    public String edit(User user) {
        userRepository.save(user);
        return "redirect:/users";
    }


}
