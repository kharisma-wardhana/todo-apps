package com.kharis.todo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kharis.todo.model.AppLog;

public interface AppLogRepo extends MongoRepository<AppLog, String> {
}
