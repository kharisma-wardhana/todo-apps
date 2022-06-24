package com.kharis.todo.controller;

import com.kharis.todo.model.User;
import com.kharis.todo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    @Autowired
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    
    @GetMapping("/")
    public String index() {
        return "redirect:/auth/login";
    }

    @GetMapping("/auth/login")
    public String showLoginPage(){
        return "login";
    }

    @GetMapping("/auth/register")
    public String showRegisterPage(){
        return "register";
    }

    @GetMapping("/auth/forgot-password")
    public String showForgotPassword(){
        return "forgot-password";
    }

    @PostMapping("/auth/login")
    public String doLogin(
        @RequestParam("username") String username, 
        @RequestParam("password") String password
    ) 
    {
        User user = authService.login(username, password);
        if (user != null) {
            return "redirect:/todos";
        }
        return "login";
    }

    @PostMapping("/auth/register")
    public void doRegister(){}

    @PostMapping("/auth/forgot-password")
    public void doForgotPassword(){}
}
