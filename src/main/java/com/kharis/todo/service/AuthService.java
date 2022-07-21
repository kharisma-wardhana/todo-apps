package com.kharis.todo.service;

import com.kharis.todo.model.AppUser;

public interface AuthService {
    AppUser login(String username, String password);

    AppUser register(String username, String email, String password);

    void forgotPassword(String email);

    void resetPassword(String email);
}
