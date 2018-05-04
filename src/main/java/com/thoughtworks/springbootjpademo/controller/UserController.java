package com.thoughtworks.springbootjpademo.controller;

import com.thoughtworks.springbootjpademo.entity.User;
import com.thoughtworks.springbootjpademo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping()
    public String list(@RequestParam(name = "page", defaultValue = "0") Integer page,
                       @RequestParam(name = "size", defaultValue = "10") Integer size, Model model) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "id");
        Page<User> userList = userRepository.findAll(pageable);
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
