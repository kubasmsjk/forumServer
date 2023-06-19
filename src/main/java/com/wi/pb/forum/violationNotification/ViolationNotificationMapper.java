package com.wi.pb.forum.violationNotification;

import com.wi.pb.forum.infrastructure.SimpleMapper;
import com.wi.pb.forum.post.dto.PostDTO;
import com.wi.pb.forum.user.ForumUserMapper;
import com.wi.pb.forum.user.dto.ForumUserDTO;
import com.wi.pb.forum.violationNotification.dto.ViolationNotificationDTO;
import org.mapstruct.Mapper;

@Mapper(uses = {ForumUserMapper.class})
interface ViolationNotificationMapper extends SimpleMapper<ViolationNotification, ViolationNotificationDTO> {

    @Override
    ViolationNotification toEntity(ViolationNotificationDTO violationNotificationDTO);

    ForumUser map(ForumUserDTO value);
    Post map(PostDTO value);
}
