package com.wi.pb.forum.post;

import com.wi.pb.forum.infrastructure.SimpleFacade;
import com.wi.pb.forum.post.dto.CommentDTO;

public class CommentFacade implements SimpleFacade<CommentDTO, Long> {
    private final CommentService commentService;

    public CommentFacade(CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    public CommentService getService() {
        return commentService;
    }
}
