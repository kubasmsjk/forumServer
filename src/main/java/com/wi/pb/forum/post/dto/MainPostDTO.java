package com.wi.pb.forum.post.dto;

import com.wi.pb.forum.category.dto.CategoryDTO;
import com.wi.pb.forum.user.dto.ForumUserDTO;

import java.util.Set;

public class MainPostDTO extends PostDTO {

    private String title;
    private CategoryDTO category;
    private Set<ForumUserDTO> viewers;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public Set<ForumUserDTO> getViewers() {
        return viewers;
    }

    public void setViewers(Set<ForumUserDTO> viewers) {
        this.viewers = viewers;
    }
}
