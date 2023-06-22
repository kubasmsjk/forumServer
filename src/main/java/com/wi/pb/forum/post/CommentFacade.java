package com.wi.pb.forum.post;

import com.wi.pb.forum.infrastructure.SimpleFacade;
import com.wi.pb.forum.post.dto.CommentDTO;

import java.util.List;

public class CommentFacade implements SimpleFacade<CommentDTO, Long> {
    private final CommentService commentService;
    private final CreateCommentCommandHandler createCommentCommandHandler;

    public CommentFacade(CommentService commentService, CreateCommentCommandHandler createCommentCommandHandler) {
        this.commentService = commentService;
        this.createCommentCommandHandler = createCommentCommandHandler;
    }

    @Override
    public CommentService getService() {
        return commentService;
    }

    public CommentDTO createComment(CreateCommentCommand command) {
        return createCommentCommandHandler.handle(command);
    }

    public List<CommentDTO> findDtosById(Long id) {
       return commentService.findAllByMainPostId(id);
    }
}
