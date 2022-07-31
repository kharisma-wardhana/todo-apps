package com.kharis.todov2.service;

import java.util.List;
import java.util.Optional;

import com.kharis.todov2.model.AppUser;

public interface AppUserService {
  public Optional<AppUser> signIn(String username, String password);

  public Optional<AppUser> signUp(String fullname, String username, String email, String password);

  public void sendResetPasswordLink(String email);

  public AppUser updateAppUser(String fullname, String username, String email);

  public AppUser updatePassword(String password);

  public AppUser getLatestUpdatedUser();

  public List<AppUser> getAllUsers();
}
