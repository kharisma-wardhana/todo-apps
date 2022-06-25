package com.kharis.todo.service;

import com.kharis.todo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    @Override
    public List<Todo> getAllTodo() {
        return null;
    }

    @Override
    public List<Todo> getByUsername(String username) {
        return null;
    }

    @Override
    public Todo getTodoById(Integer todoId) {
        return null;
    }

    @Override
    public void createTodo() {

    }

    @Override
    public void updateTodo(Todo todo) {

    }

    @Override
    public void deleteTodo(Integer todoId) {

    }
}
