package com.kharis.todo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.kharis.todo.model.Todo;

// @Repository
// @Transactional
public class TodoJpaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Todo todo) {
        entityManager.merge(todo);
    }

    public Todo getTodoById(long id) {
        return entityManager.find(Todo.class, id);
    }

    public void deleteById(long id) {
        Todo todo = entityManager.find(Todo.class, id);
        entityManager.remove(todo);
    }
}
