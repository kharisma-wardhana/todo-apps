package com.kharis.todo.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Document(collection = "app_log")
@Builder
public class AppLog {
  @Id
  private String id;
  private String ipAddress;
  private String userAgent;
  private String message;
}
