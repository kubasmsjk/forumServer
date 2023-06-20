package com.wi.pb.forum.post;

import com.wi.pb.forum.user.dto.ForumUserDTO;

import java.util.Set;

public class CreateMainPostCommand {
    private String description;
    private Long authorId;
    private String title;
    private Long categoryId;
    private Set<ForumUser> viewers;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Set<ForumUser> getViewers() {
        return viewers;
    }

    public void setViewers(Set<ForumUser> viewers) {
        this.viewers = viewers;
    }
}