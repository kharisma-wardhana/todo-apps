package com.kharis.todo.service;

import com.kharis.todo.model.User;

import java.util.List;

public interface UserService {
    void createUser();
    void updateUser(User user);
    void deleteUser(Integer userId);
    List<User> getAllUser();
    User getUserById(Integer userId);
    User getUserByUsername(String username);
}
