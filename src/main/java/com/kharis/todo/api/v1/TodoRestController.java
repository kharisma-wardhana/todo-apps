package com.kharis.todo.api.v1;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kharis.todo.model.Todo;
import com.kharis.todo.service.TodoService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/todos")
@RequiredArgsConstructor
public class TodoRestController {
  private final TodoService todoService;

  @GetMapping("/")
  public ResponseEntity<List<Todo>> getAllTodos() {
    return ResponseEntity.ok(todoService.getAllTodo());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
    return ResponseEntity.ok(todoService.getTodoById(id).orElse(null));
  }

  @PostMapping(value = "/")
  public ResponseEntity<Todo> createNewTodo(@RequestBody Todo todo) {
    todoService.createTodo(todo.getTitle(), todo.getDescription(), todo.getStatus());
    return ResponseEntity.ok(todo);
  }

}
