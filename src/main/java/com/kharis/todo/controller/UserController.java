package com.kharis.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UserController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "list_user";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") Integer id) {
        return "detail_user";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable("id") Integer id) {
        return "detail_user";
    }
}
