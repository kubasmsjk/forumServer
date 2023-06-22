package com.wi.pb.forum.post.controllers;

import com.wi.pb.forum.post.CommentFacade;
import com.wi.pb.forum.post.CreateCommentCommand;
import com.wi.pb.forum.post.dto.CommentDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/comment")
public class CommentController {

    private final CommentFacade commentFacade;

    public CommentController(CommentFacade commentFacade) {
        this.commentFacade = commentFacade;
    }

    @GetMapping
    public List<CommentDTO> getAllEntities(){
        return commentFacade.findAllDto();
    }

    @GetMapping("/{id}")
    public Optional<CommentDTO> getEntityById(@PathVariable Long id){
        return commentFacade.findDtoById(id);
    }

    @PostMapping
    public CommentDTO addEntity(@Valid @RequestBody CreateCommentCommand command) {
        return commentFacade.createComment(command);
    }

    @DeleteMapping("/{id}")
    public void deleteEntityById(@PathVariable Long id) {
        commentFacade.deleteById(id);
    }
}
