package com.kharis.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kharis.todo.model.Todo;

public interface TodoRepoTest extends JpaRepository<Todo, Long> {
    
}
