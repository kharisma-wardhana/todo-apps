package com.kharis.todo.service;

import com.kharis.todo.model.AppLog;
import com.kharis.todo.model.AppUser;
import com.kharis.todo.repository.AppLogRepo;
import com.kharis.todo.repository.AppUserRepo;

import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AppUserRepo appUserRepo;
    private final AppLogRepo appLogRepo;

    @Override
    public AppUser login(String username, String password) {
        return null;
    }

    @Override
    public AppUser register(String username, String email, String password) {
        return null;
    }

    @Override
    public void forgotPassword(String email) {

    }

    @Override
    public void resetPassword(String email) {

    }
}
