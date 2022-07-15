package com.kharis.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kharis.todo.model.Todo;

public interface TodoSpringDataJpaRepo extends JpaRepository<Todo, Integer> {

}
