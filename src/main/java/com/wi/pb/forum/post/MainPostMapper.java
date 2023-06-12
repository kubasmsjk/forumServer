package com.wi.pb.forum.post;

import com.wi.pb.forum.infrastructure.SimpleMapper;
import com.wi.pb.forum.post.dto.MainPostDTO;
import org.mapstruct.Mapper;

@Mapper
interface MainPostMapper extends SimpleMapper<MainPost, MainPostDTO> {
}
