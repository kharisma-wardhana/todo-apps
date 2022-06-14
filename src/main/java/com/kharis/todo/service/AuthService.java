package com.kharis.todo.service;

import com.kharis.todo.model.User;

public interface AuthService {
    User login(String username, String password);
    User register(String username, String email, String password);
    void forgotPassword(String email);
    void resetPassword(String email);
}
