package com.nf.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/hello")
    public String xinChao(@RequestParam(name = "names", required = false, defaultValue = "OOO") String nameNew, Model model) {
        model.addAttribute("name", nameNew);
        return "hello";
    }
}
