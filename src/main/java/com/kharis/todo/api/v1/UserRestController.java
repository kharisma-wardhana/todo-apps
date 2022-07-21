package com.kharis.todo.api.v1;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kharis.todo.model.AppUser;
import com.kharis.todo.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestController {
  private final UserService userService;

  @GetMapping("/")
  public ResponseEntity<List<AppUser>> getAllUsers() {
    return ResponseEntity.ok(userService.getAllUser());
  }

  @GetMapping("/{id}")
  public ResponseEntity<AppUser> getUserById(@PathVariable Long id) {
    return ResponseEntity.ok(userService.getUserById(id));
  }

  @GetMapping("/username/{username}")
  public ResponseEntity<AppUser> getUserByUsername(@PathVariable String username) {
    return ResponseEntity.ok(userService.getUserByUsername(username));
  }
}
