package com.nf.demo.controller;

import com.nf.demo.model.User;
import com.nf.demo.repository.UserRepository;
import com.nf.demo.service.UserServiceImpl;
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

    @GetMapping("/register")
    public String registerAccount(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String registerAccount(@ModelAttribute("userSave") User user) {
        userRepository.save(user);
        return "login";
    }
    @GetMapping("/login")
    public String loginAccount(Model model) {
        model.addAttribute("userLogin", new User());
        return "login";
    }
    @PostMapping("/login")
    public String loginAccount(@RequestParam(name = "username") String user_name, @RequestParam(name = "password") String password, Model model) {
        model.addAttribute("username", user_name);
        model.addAttribute("password", password);
        userService.loginAccount(user_name, password);
        return "success";
    }
//    @PostMapping("/login")
//    public String login(@RequestParam String userName, @RequestParam String password, HttpSession session, Model model) {
//        User user = userRepository.findByUserName(userName);
//        if (user != null && user.getPassword().equals(password)) {
//            session.setAttribute("userLogin", user);
//            return "helloUser";
//        } else {
//            model.addAttribute("error", "Invalid username or password");
//            return "login";
//        }
//    }
}
