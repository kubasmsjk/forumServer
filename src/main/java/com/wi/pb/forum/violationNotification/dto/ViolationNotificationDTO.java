package com.wi.pb.forum.violationNotification.dto;

import com.wi.pb.forum.infrastructure.Identifiable;
import com.wi.pb.forum.post.dto.PostDTO;
import com.wi.pb.forum.user.dto.ForumUserDTO;

public class ViolationNotificationDTO implements Identifiable<Long> {
    private Long id;
    private PostDTO post;
    private String description;
    private ForumUserDTO informer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PostDTO getPost() {
        return post;
    }

    public void setPost(PostDTO post) {
        this.post = post;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ForumUserDTO getInformer() {
        return informer;
    }

    public void setInformer(ForumUserDTO informer) {
        this.informer = informer;
    }
}
