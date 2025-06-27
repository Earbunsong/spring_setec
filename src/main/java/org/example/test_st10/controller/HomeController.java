package org.example.test_st10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
    @GetMapping("/sample")
    public String showWelcomePage(Model model) {
        model.addAttribute("message", "Welcome to Spring Boot with Thymeleaf!");
        return "sample"; // Maps to welcome.html in templates folder
    }
    @GetMapping("/welcome")
    public String string(Model model) {
        model.addAttribute("message", "Welcome to Spring Boot with Thymeleaf!");
        return "/user/welcome"; // Maps to welcome.html in templates folder
    }
    @GetMapping("/test")
    public String test(Model model) {
        return "/user/index";
    }
    @GetMapping("/cv")
    public String cv(Model model) {
        return "/user/cv-template";
    }

}

