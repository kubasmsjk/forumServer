package com.wi.pb.forum.user.dto;

import com.wi.pb.forum.infrastructure.Identifiable;
import com.wi.pb.forum.user.Role;

import java.util.Date;

public class ForumUserDTO implements Identifiable<Long> {
    private Long id;
    private Role role;
    private String username;
    private String email;
    private Date createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
