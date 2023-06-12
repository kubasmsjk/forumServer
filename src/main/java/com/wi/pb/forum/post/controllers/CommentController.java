package com.wi.pb.forum.post.controllers;

import com.wi.pb.forum.infrastructure.SimpleController;
import com.wi.pb.forum.infrastructure.SimpleFacade;
import com.wi.pb.forum.post.CommentFacade;
import com.wi.pb.forum.post.dto.CommentDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/comment")
public class CommentController implements SimpleController<CommentDTO, Long> {

    private final CommentFacade commentFacade;

    public CommentController(CommentFacade commentFacade) {
        this.commentFacade = commentFacade;
    }

    @Override
    public CommentFacade getFacade() {
        return commentFacade;
    }
}
