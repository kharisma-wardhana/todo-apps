package com.kharis.todo.controller;

import com.kharis.todo.model.Todo;
import com.kharis.todo.model.User;
import com.kharis.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import java.util.List;

@Controller
@SessionAttributes("user")
public class TodoController {
    @Autowired
    private final TodoService todoService;
    
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    
    @GetMapping("/todos")
    public String showAllTodo(ModelMap model){
        Object user = model.get("user");
        System.out.println(user);
        if (user == null) {
            return "redirect:/auth/login";
        }
        List<Todo> todos = todoService.getAllTodo();
        model.addAttribute("todos", todos);
        return "list_todo";
    }

    @GetMapping("/todos/{id}")
    public String showTodo(Todo todo){
        return "detail_todo";
    }

    @GetMapping("/todos/add")
    public String addNewTodo(ModelMap model){
        Object user = model.get("user");
        if (user == null) {
            return "redirect:/auth/login";
        }
        return "todo";
    }

    @PostMapping("/todos/add")
    public String createTodo(
        @RequestParam String title, 
        @RequestParam String description, 
        @RequestParam String status)
    {
        todoService.createTodo(title, description, status);
        return "redirect:/todos";
    }

    @PutMapping("/todos/{id}")
    public void updateTodo(Todo todo){}

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(Todo todo){}

}
