package com.kharis.todo.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class AppUser {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    private final Collection<Role> roles = new ArrayList<>();

    private Integer status;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "created_at")
    private Date createdAt;
}
