package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenicationController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "/login";
    }
    @GetMapping("/logout")
    public String logout(){
        return "redirect:/login?logout";
    }
}
