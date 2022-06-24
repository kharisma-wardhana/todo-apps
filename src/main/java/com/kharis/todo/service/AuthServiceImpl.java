package com.kharis.todo.service;

import com.kharis.todo.model.User;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public User login(String username, String password) {
        if (username.equals("admin") && password.equals("admin")) {
            return new User(
                1, 
                "admin", 
                "admin", 
                "admin@example.com", 
                1
            );
        }
        return null;
    }

    @Override
    public User register(String username, String email, String password) {
        return null;
    }

    @Override
    public void forgotPassword(String email) {

    }

    @Override
    public void resetPassword(String email) {

    }
}
