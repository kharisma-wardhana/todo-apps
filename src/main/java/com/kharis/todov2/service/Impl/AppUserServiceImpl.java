package com.kharis.todov2.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kharis.todov2.model.AppUser;
import com.kharis.todov2.repository.AppUserRepo;
import com.kharis.todov2.service.AppUserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {
  private final AppUserRepo appUserRepo;

  @Override
  public Optional<AppUser> signIn(String username, String password) {
    log.info("signIn: {} pass: {}", username, password);
    return appUserRepo.findByUsernameAndPassword(username, password);
  }

  @Override
  public Optional<AppUser> signUp(String fullname, String username, String email, String password) {
    // TODO Auto-generated method stub
    return Optional.empty();
  }

  @Override
  public void sendResetPasswordLink(String email) {
    // TODO Auto-generated method stub

  }

  @Override
  public AppUser updateAppUser(String fullname, String username, String email) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AppUser updatePassword(String password) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AppUser getLatestUpdatedUser() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<AppUser> getAllUsers() {
    log.info("Get all users");
    return appUserRepo.findAll();
  }

}
