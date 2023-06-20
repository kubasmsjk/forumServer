package com.wi.pb.forum.user.dto;

import com.wi.pb.forum.user.Role;

import java.util.Set;

public class CreateForumUserCommand {
    private Role role;
    private String username;
    private String email;
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
