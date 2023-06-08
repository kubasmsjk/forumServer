package com.wi.pb.forum.user;

import com.wi.pb.forum.infrastructure.SimpleMapper;
import com.wi.pb.forum.user.dto.ForumUserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ForumUserMapper extends SimpleMapper<ForumUser, ForumUserDTO> {

}
