package com.kharis.todov2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kharis.todov2.model.AppUser;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {
  public Optional<AppUser> findByUsernameOrEmail(String username, String email);

  public Optional<AppUser> findByUsername(String username);

  public Optional<AppUser> findByEmail(String email);

  public Optional<AppUser> findByUsernameAndPassword(String username, String password);

  public Optional<AppUser> findByEmailAndPassword(String email, String password);

  public Optional<AppUser> findByIsActive(Boolean isActive);

  @Query(value = "SELECT * FROM users WHERE role = ?1", nativeQuery = true)
  public Optional<AppUser> findByRole(String role);

  @Query("SELECT u FROM users u WHERE u.updatedAt = (SELECT MAX(u2.updatedAt) FROM users u2)")
  public AppUser getLatestUpdatedUser();
}
