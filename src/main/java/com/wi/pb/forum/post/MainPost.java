package com.wi.pb.forum.post;

import com.wi.pb.forum.infrastructure.Identifiable;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class MainPost extends Post implements Identifiable<Long> {

    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "forum_user_main_post",
            joinColumns = @JoinColumn(name = "main_post_id"),
            inverseJoinColumns = @JoinColumn(name = "forum_user_id"))
    private Set<ForumUser> viewers;


    @Override
    public Long getId() {
        return super.getId();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<ForumUser> getViewers() {
        return viewers;
    }

    public void setViewers(Set<ForumUser> viewers) {
        this.viewers = viewers;
    }
}
