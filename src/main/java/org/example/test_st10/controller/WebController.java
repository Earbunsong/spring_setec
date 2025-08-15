package org.example.test_st10.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    @GetMapping("/")
    public String home() {
        return "redirect:/dashboard";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {
        if (error != null) {
            model.addAttribute("errorMsg", "Invalid username or password!");
        }
        if (logout != null) {
            model.addAttribute("logoutMsg", "You have been logged out successfully!");
        }
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication, Model model) {
        model.addAttribute("username", authentication.getName());

        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return "redirect:/admin/dashboard";
        } else {
            return "redirect:/user/dashboard";
        }
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard(Model model, Authentication authentication) {
        model.addAttribute("username", authentication.getName());
        model.addAttribute("role", "Administrator");
        return "admin/dashboard";
    }

    @GetMapping("/user/dashboard")
    public String userDashboard(Model model, Authentication authentication) {
        model.addAttribute("username", authentication.getName());
        model.addAttribute("role", "User");
        return "user/dashboard";
    }

    @GetMapping("/admin/users")
    public String adminUsers(Model model, Authentication authentication) {
        model.addAttribute("username", authentication.getName());
        return "admin/users";
    }

    @GetMapping("/user/profile")
    public String userProfile(Model model, Authentication authentication) {
        model.addAttribute("username", authentication.getName());
        return "user/profile";
    }
}