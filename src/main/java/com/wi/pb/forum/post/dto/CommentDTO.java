package com.wi.pb.forum.post.dto;

import com.wi.pb.forum.post.MainPost;
import com.wi.pb.forum.post.Post;

public class CommentDTO extends Post {

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
