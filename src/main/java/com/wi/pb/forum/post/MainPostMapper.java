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
    @Mapping(source = "mainPostDTO.author", target = "author")
    MainPost toEntity(MainPostDTO mainPostDTO);

    @Mapping(target = "id", source = "id")
    ForumUser map(ForumUserDTO value);
}
