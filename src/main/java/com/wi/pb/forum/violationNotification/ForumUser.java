package com.wi.pb.forum.violationNotification;

import com.wi.pb.forum.user.Role;
import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

import java.time.LocalDateTime;
import java.util.Date;

@Immutable
@Table(name="ForumUser")
@Entity(name = "ViolationNotificationForumUser")
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
}
