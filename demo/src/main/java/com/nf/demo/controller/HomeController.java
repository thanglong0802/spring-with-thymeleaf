package com.nf.demo.controller;

import com.nf.demo.model.User;
import com.nf.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    /*@RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerAccountOne(@ModelAttribute("user") User user) {
        return "register";
    }*/

    @GetMapping("/register")
    public String registerAccount(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute("user") User user) {
        System.out.println(user);
        userRepository.save(user);
        return "register";
    }

    /*@PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        return null;
    }*/

    @GetMapping("/login")
    public String loginAccount() {
        return "login";
    }
}
