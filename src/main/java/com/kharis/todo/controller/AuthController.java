package com.kharis.todo.controller;

import com.kharis.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterPage(){
        return "register";
    }

    @GetMapping("/forgot-password")
    public String showForgotPassword(){return "forgot-password";}
}
