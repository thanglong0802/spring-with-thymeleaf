package com.nf.demo.controller;

import com.nf.demo.model.User;
import com.nf.demo.repository.UserRepository;
import com.nf.demo.service.UserServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/register")
    public String registerAccount(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "infoUser";
    }

    @GetMapping("/login")
    public String loginAccount() {
        return "login";
    }
    @PostMapping("/login")
    public String login(@RequestParam String userName, @RequestParam String password, HttpSession session, Model model) {
        User user = userRepository.findByUserName(userName);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("userLogin", user);
            return "helloUser";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}
