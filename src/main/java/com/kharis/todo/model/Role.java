package com.kharis.todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity(name = "roles")
public class Role {
  @Id
  @GeneratedValue
  private Long id;

  private String name;
}
