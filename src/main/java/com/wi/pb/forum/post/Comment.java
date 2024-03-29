package com.wi.pb.forum.post;

import com.wi.pb.forum.infrastructure.Identifiable;
import jakarta.persistence.*;

@Entity
@Table
class Comment extends Post implements Identifiable<Long> {

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "main_post_id")
    private MainPost mainPost;

    @Override
    public Long getId() {
        return super.getId();
    }

    public MainPost getMainPost() {
        return mainPost;
    }

    public void setMainPost(MainPost mainPost) {
        this.mainPost = mainPost;
    }
}
