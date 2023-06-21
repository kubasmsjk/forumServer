package com.wi.pb.forum.violationNotification;

import com.wi.pb.forum.infrastructure.Identifiable;
import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

import java.util.Set;

@Immutable
@Table(name="MainPost")
@Entity(name = "ViolationNotificationMainPost")
class MainPost extends Post implements Identifiable<Long> {

    private String title;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "forum_user_main_post",
            joinColumns = @JoinColumn(name = "main_post_id"),
            inverseJoinColumns = @JoinColumn(name = "forum_user_id"))
    private Set<ForumUser> viewers;


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
