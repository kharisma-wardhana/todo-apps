package com.kharis.todo.controller;

import com.kharis.todo.model.AppUser;
import com.kharis.todo.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        super();
        this.authService = authService;
    }

    @GetMapping("/")
    public String index(ModelMap model) {
        return "redirect:/todos";
    }

    @GetMapping("/auth/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/auth/register")
    public String showRegisterPage() {
        return "register";
    }

    @GetMapping("/auth/forgot-password")
    public String showForgotPassword() {
        return "forgot-password";
    }

    @PostMapping("/auth/login")
    public String doLogin(
            ModelMap model,
            @RequestParam("username") String username,
            @RequestParam("password") String password) {
        AppUser user = authService.login(username, password);
        if (user != null) {
            model.put("user", user);
            return "redirect:/todos";
        }
        return "login";
    }

    @PostMapping("/auth/register")
    public String doRegister(
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("confirmPassword") String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            return "register";
        }
        AppUser user = authService.register(username, email, password);
        if (user != null) {
            return "redirect:/todos";
        }
        return "register";
    }

    @PostMapping("/auth/forgot-password")
    public String doForgotPassword(@RequestParam("email") String email) {
        authService.forgotPassword(email);
        return "forgot-password";
    }
}
