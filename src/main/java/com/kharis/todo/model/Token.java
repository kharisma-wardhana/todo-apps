package com.kharis.todo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "app_tokens")
public class Token {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    private String token;

    @Column(name = "token_expired")
    private String tokenExpired;

    @Column(name = "refresh_token")
    private String refreshToken;

    @Column(name = "refresh_token_expired")
    private String refreshTokenExpired;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;
}
