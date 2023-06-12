package com.wi.pb.forum.post;

import com.wi.pb.forum.infrastructure.SimpleMapper;
import com.wi.pb.forum.post.dto.CommentDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CommentMapper extends SimpleMapper<Comment, CommentDTO> {
}
