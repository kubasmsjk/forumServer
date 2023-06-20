package com.wi.pb.forum.violationNotification;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

@Immutable
@Table(name="Post")
@Entity(name = "ViolationNotificationPost")
class Post {

    @Id
    private Long id;
    private String description;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "forum_user_id", referencedColumnName = "id")
    private ForumUser author;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ForumUser getAuthor() {
        return author;
    }

    public void setAuthor(ForumUser author) {
        this.author = author;
    }
}
