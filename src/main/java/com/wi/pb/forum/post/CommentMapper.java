package com.wi.pb.forum.post;

import com.wi.pb.forum.infrastructure.SimpleMapper;
import com.wi.pb.forum.post.dto.CommentDTO;
import com.wi.pb.forum.user.ForumUserMapper;
import com.wi.pb.forum.user.dto.ForumUserDTO;
import org.mapstruct.Mapper;

@Mapper( uses = {ForumUserMapper.class})
interface CommentMapper extends SimpleMapper<Comment, CommentDTO> {

    @Override
    //@Mapping(source = "commentDTO.author",target = "author", ignore = true)
    Comment toEntity(CommentDTO commentDTO);

    ForumUser map(ForumUserDTO value);
}
