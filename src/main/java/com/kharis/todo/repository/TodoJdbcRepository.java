package com.kharis.todo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kharis.todo.model.Todo;

// @Repository
public class TodoJdbcRepository {
    @Autowired
    private final JdbcTemplate jdbcTemplate;
    
    public TodoJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SELECT_QUERY = 
    """
        SELECT * FROM todos WHERE id = ?
    """;

    private static final String INSERT_QUERY = 
    """
        INSERT INTO todos (title, description, status)
        VALUES (?, ?, ?) 
    """;

    private static final String DELETE_QUERY = 
    """
        DELETE FROM todos WHERE id = ?
    """;

    public Todo getTodoById(long id)
    {
        return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Todo.class), id);
    }

    public void insert(Todo todo)
    {
        jdbcTemplate.update(INSERT_QUERY, todo.getTitle(), todo.getDescription(), todo.getStatus());
    }

    public void deleteById(long id)
    {
        jdbcTemplate.update(DELETE_QUERY, id);
    }
}
