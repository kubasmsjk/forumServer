package com.wi.pb.forum.user.dto;

import com.wi.pb.forum.infrastructure.Identifiable;
import com.wi.pb.forum.user.Role;

import java.time.LocalDateTime;
import java.util.Set;

public class ForumUserDTO implements Identifiable<Long> {
    private Long id;
    private Set<Role> roles;
    private String username;
    private String email;
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
