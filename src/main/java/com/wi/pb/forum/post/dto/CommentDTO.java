package com.wi.pb.forum.post.dto;

public class CommentDTO extends PostDTO {

    private MainPostDTO mainPost;

    public MainPostDTO getMainPost() {
        return mainPost;
    }

    public void setMainPost(MainPostDTO mainPost) {
        this.mainPost = mainPost;
    }
}
