package com.nf.springboot.controller;

import com.nf.springboot.model.Info;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        List<Info> listInfo = new ArrayList<>();
        listInfo.add(new Info("Nguyen Thang Long", "123"));
        listInfo.add(new Info("Ho Huu Quang", "456"));
        listInfo.add(new Info("Le Dang Quang", "789"));
        model.addAttribute("profile", listInfo);
        return "profile";
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
