package com.wi.pb.forum.post.dto;

import com.wi.pb.forum.user.dto.ForumUserDTO;

public class PostDTO {

    private Long id;
    private String description;
    private ForumUserDTO author;

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

    public ForumUserDTO getAuthor() {
        return author;
    }

    public void setAuthor(ForumUserDTO author) {
        this.author = author;
    }
}
