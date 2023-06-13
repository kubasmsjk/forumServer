package com.wi.pb.forum.post;

import com.wi.pb.forum.infrastructure.service.CrudService;
import com.wi.pb.forum.post.dto.CommentDTO;
import org.springframework.data.jpa.repository.JpaRepository;

class CommentService implements CrudService<Comment, CommentDTO, Long> {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public CommentService(CommentRepository commentRepository,
                          CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    @Override
    public JpaRepository<Comment, Long> getRepo() {
        return commentRepository;
    }

    @Override
    public String getEntityName() {
        return Comment.class.getName();
    }

    @Override
    public Comment mapToEntity(CommentDTO commentDTO) {
        return commentMapper.toEntity(commentDTO);
    }

    @Override
    public CommentDTO mapToDto(Comment entity) {
        return commentMapper.toDto(entity);
    }
}
