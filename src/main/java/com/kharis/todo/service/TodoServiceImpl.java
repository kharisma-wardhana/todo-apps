package com.kharis.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.kharis.todo.model.AppLog;
import com.kharis.todo.model.AppUser;
import com.kharis.todo.model.Todo;
import com.kharis.todo.repository.AppLogRepo;
import com.kharis.todo.repository.AppUserRepo;
import com.kharis.todo.repository.TodoSpringDataJpaRepo;

@Service
public class TodoServiceImpl implements TodoService {
    private final TodoSpringDataJpaRepo todoRepository;
    private final AppUserRepo userRepository;
    private final AppLogRepo logRepository;

    private int todoCount = 1;

    public TodoServiceImpl(TodoSpringDataJpaRepo todoRepository, AppUserRepo userRepository, AppLogRepo logRepository) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
        this.logRepository = logRepository;
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
    public Optional<Todo> getTodoById(Long todoId) {
        return this.todoRepository.findById(todoId);
    }

    @Override
    public void createTodo(String title, String description, String status) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AppUser user = userRepository.findByUsername(auth.getName())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Todo todo = new Todo(todoCount++, user.getId(), title, description, status);
        this.todoRepository.save(todo);
        AppLog appLog = AppLog.builder()
                .ipAddress("localhost")
                .userAgent("local-browser")
                .message("User " + user.getUsername() + " created new todo " + todo.getTitle())
                .build();
        logRepository.insert(appLog);
    }

    @Override
    public void updateTodo(Todo todo) {
        this.todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(Long todoId) {
        this.todoRepository.deleteById(todoId);
    }
}
