package com.wi.pb.forum.post;

import com.wi.pb.forum.user.Role;
import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

import java.util.Date;

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
    private Date createdAt;

    public ForumUser() {

    }
}
