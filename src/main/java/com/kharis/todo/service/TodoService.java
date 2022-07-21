package com.kharis.todo.service;

import com.kharis.todo.model.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    List<Todo> getAllTodo();

    List<Todo> getByUsername(String username);

    Optional<Todo> getTodoById(Long todoId);

    void createTodo(String title, String description, String status);

    void updateTodo(Todo todo);

    void deleteTodo(Long todoId);
}
