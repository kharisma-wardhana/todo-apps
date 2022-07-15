package com.kharis.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.kharis.todo.model.Todo;
import com.kharis.todo.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;
    private int todoCount = 1;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> getAllTodo() {
        return this.todoRepository.findAll();
    }

    @Override
    public List<Todo> getByUsername(String username) {
        return null;
    }

    @Override
    public Todo getTodoById(Integer todoId) {
        return this.todoRepository.findById(todoId);
    }

    @Override
    public void createTodo(String title, String description, String status) {
        Todo todo = new Todo(todoCount++, title, description, status);
        this.todoRepository.save(todo);
    }

    @Override
    public void updateTodo(Todo todo) {
        this.todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(Integer todoId) {
        this.todoRepository.deleteById(todoId);
    }
}
