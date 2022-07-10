package com.kharis.todo.service;

import com.kharis.todo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    private static List<Todo> todos = new ArrayList<Todo>();
    private int todoCount = 3;
    static {
        todos.add(new Todo(1, "test-todo", "Learn Spring MVC", ""));
        todos.add(new Todo(2, "test-todo", "Learn Struts", ""));
        todos.add(new Todo(3, "test-todo", "Learn Hibernate",""));
    }

    @Override
    public List<Todo> getAllTodo() {
        return todos;
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
    public void createTodo(String title, String description, String status) {
        todos.add(new Todo(++todoCount, title, description, status));
    }

    @Override
    public void updateTodo(Todo todo) {

    }

    @Override
    public void deleteTodo(Integer todoId) {

    }
}
