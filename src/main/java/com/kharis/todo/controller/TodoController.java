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

    @GetMapping("/todo")
    public String showAllTodo(){
        return "index_todo";
    }

    @GetMapping("/todo/{id}")
    public String showTodo(Todo todo){
        return "todo";
    }

    @PostMapping("/todo")
    public void createTodo(Todo todo){}

    @PutMapping("/todo/{id}")
    public void updateTodo(Todo todo){}

    @DeleteMapping("/todo/{id}")
    public void deleteTodo(Todo todo){}

}
