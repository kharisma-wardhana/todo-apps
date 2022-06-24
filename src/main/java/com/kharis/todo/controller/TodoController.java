package com.kharis.todo.controller;

import com.kharis.todo.model.Todo;
import com.kharis.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    public String showAllTodo(){
        return "list_todo";
    }

    @GetMapping("/todos/{id}")
    public String showTodo(Todo todo){
        return "detail_todo";
    }

    @PostMapping("/todos")
    public void createTodo(Todo todo){}

    @PutMapping("/todos/{id}")
    public void updateTodo(Todo todo){}

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(Todo todo){}

}
