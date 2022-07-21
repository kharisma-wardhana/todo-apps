package com.kharis.todo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kharis.todo.model.AppUser;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {
  public Optional<AppUser> findByUsername(String username);
}
