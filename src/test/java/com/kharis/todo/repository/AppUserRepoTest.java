package com.kharis.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kharis.todo.model.AppUser;

public interface AppUserRepoTest extends JpaRepository<AppUser, Long> {
    
}
