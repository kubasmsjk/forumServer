package com.wi.pb.forum.post;

import com.wi.pb.forum.post.dto.CommentDTO;

import java.util.List;

public class CommentFacade {
    private final CommentService commentService;

    public CommentFacade(CommentService commentService) {
        this.commentService = commentService;
    }

    public List<CommentDTO> findAll() {
        return commentService.findAllDto();
    }
}
