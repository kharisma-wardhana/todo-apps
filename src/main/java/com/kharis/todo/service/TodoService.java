package com.kharis.todo.service;

import com.kharis.todo.model.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAllTodo();
    List<Todo> getByUsername(String username);
    Todo getTodoById(Integer todoId);
    void createTodo();
    void updateTodo(Todo todo);
    void deleteTodo(Integer todoId);
}
