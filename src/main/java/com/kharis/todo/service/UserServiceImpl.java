package com.kharis.todo.service;

import com.kharis.todo.model.AppUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void createUser() {

    }

    @Override
    public void updateUser(AppUser user) {

    }

    @Override
    public void deleteUser(Long userId) {

    }

    @Override
    public List<AppUser> getAllUser() {
        return null;
    }

    @Override
    public AppUser getUserById(Long userId) {
        return null;
    }

    @Override
    public AppUser getUserByUsername(String username) {
        return null;
    }
}
