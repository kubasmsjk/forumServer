package com.wi.pb.forum.violationNotification;

import com.wi.pb.forum.infrastructure.SimpleMapper;
import com.wi.pb.forum.user.ForumUserMapper;
import com.wi.pb.forum.violationNotification.dto.ViolationNotificationDTO;
import org.mapstruct.Mapper;

@Mapper(uses = {ForumUserMapper.class, SimpleMainPostMapper.class})
interface ViolationNotificationMapper extends SimpleMapper<ViolationNotification, ViolationNotificationDTO> {

}
