package com.wi.pb.forum.violationNotification;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

import java.time.LocalDateTime;

@Immutable
@Table(name="ForumUser")
@Entity(name = "ViolationNotificationForumUser")
class ForumUser  {

    @Id
    private Long id;
    private String username;
    private String password;
    private String email;
    private LocalDateTime createdAt;

    public ForumUser() {

    }

    public Long getId() {
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
