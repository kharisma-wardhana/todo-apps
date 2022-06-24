package com.kharis.todo.model;

import java.util.Date;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Integer status;
    private Date updatedAt;
    private Date createdAt;

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Integer getStatus() {
        return status;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public User(Integer id, String username, String password, String email, Integer status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.status = status;
    }

}
