package com.nf.demo.controller;

import com.nf.demo.model.User;
import com.nf.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/createUser")
    public String createUser(@RequestParam String userName, @RequestParam String password, @RequestParam String email, @ModelAttribute User user) {
//        boolean checkEmail = userService.checkEmail(user.getEmail());
//        if (checkEmail) {
//            System.out.println("Email Exist");
//        }
        boolean validate = userService.validateUser(userName, password, email);
        if (validate) {
            User userCreate = userService.createUser(user);
            if (userCreate != null) {
                System.out.println("Register Successfully");
            } else {
                System.out.println("Register fail");
            }
        }
        return "redirect:/register";
    }
    @PostMapping("/signin")
    public String login(@RequestParam("username") String userName, @RequestParam("password") String password, Model model) {
        User user = userService.loginUser(userName);
        if (user != null && user.getPassword().equals(password)) {
            model.addAttribute("userName", user.getUserName());
            return "success";
        }
        return "login";
    }
}
