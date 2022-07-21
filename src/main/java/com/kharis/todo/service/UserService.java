package com.kharis.todo.service;

import com.kharis.todo.model.AppUser;

import java.util.List;

public interface UserService {
    void createUser();

    void updateUser(AppUser user);

    void deleteUser(Long userId);

    List<AppUser> getAllUser();

    AppUser getUserById(Long userId);

    AppUser getUserByUsername(String username);
}
