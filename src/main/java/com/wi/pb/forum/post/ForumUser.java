package com.wi.pb.forum.post;

import com.wi.pb.forum.user.Role;
import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

import java.time.LocalDateTime;

@Immutable
@Table(name="ForumUser")
@Entity(name = "PostForumUser")
class ForumUser  {

    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String username;
    private String password;
    private String email;
    private LocalDateTime createdAt;

    public ForumUser() {

    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
