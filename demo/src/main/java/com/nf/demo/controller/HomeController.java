package com.nf.demo.controller;

import com.nf.demo.model.User;
import com.nf.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute User user) {
//        boolean checkEmail = userService.checkEmail(user.getEmail());
//        if (checkEmail) {
//            System.out.println("Email Exist");
//        }
        User userCreate = userService.createUser(user);
        if (userCreate != null) {
            System.out.println("Register Successfully");
        } else {
            System.out.println("Register fail");
        }

        return "redirect:/register";
    }
    @PostMapping("/login")
    public String login(@RequestParam("username") String userName, @RequestParam("password") String password) {
        User user = userService.loginUser(userName);
        if (user != null && user.getPassword().equals(password)) {
            return "success";
        }
        return "login";
    }
}
