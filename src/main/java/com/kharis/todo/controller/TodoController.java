package com.kharis.todo.controller;

import com.kharis.todo.model.Todo;
import com.kharis.todo.service.TodoService;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import java.util.List;

@Controller
@SessionAttributes("user")
public class TodoController {
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
    public String showTodo(@PathVariable int id, ModelMap model){
        Todo todo = todoService.getTodoById(id);
        model.addAttribute("todo", todo);
        return "todo";
    }

    @GetMapping("/todos/add")
    public String addNewTodo(ModelMap model){
        Object user = model.get("user");
        if (user == null) {
            return "redirect:/auth/login";
        }
        Todo todo = new Todo(0, "", "", "");
        model.put("todo", todo);
        return "todo";
    }

    @PostMapping("/todos/add")
    public String createTodo(ModelMap model, @Valid Todo todo, BindingResult result)
    {
        if (result.hasErrors()) {
            return "todo";
        }
        todoService.createTodo(todo.getTitle(), todo.getDescription(), todo.getStatus());
        return "redirect:/todos";
    }

    @PutMapping("/todos/{id}")
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if (result.hasErrors()) {
            return "todo";
        }
        todoService.updateTodo(todo);
        return "redirect:/todos";
    }

    @DeleteMapping("/todos/{id}")
    public String deleteTodo(@PathVariable int id){
        todoService.deleteTodo(id);
        return "redirect:/todos";
    }

}
