package com.wi.pb.forum.post;

import com.wi.pb.forum.infrastructure.SimpleMapper;
import com.wi.pb.forum.post.dto.MainPostDTO;
import com.wi.pb.forum.user.ForumUserMapper;
import com.wi.pb.forum.user.dto.ForumUserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper( uses = {ForumUserMapper.class})
interface MainPostMapper extends SimpleMapper<MainPost, MainPostDTO> {

    @Override
    @Mapping(source = "mainPostDTO.author", target = "author", ignore = true)
    MainPost toEntity(MainPostDTO mainPostDTO);

    ForumUser map(ForumUserDTO value);
}
