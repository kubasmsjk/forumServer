package com.wi.pb.forum.violationNotification;

import com.wi.pb.forum.infrastructure.SimpleMapper;
import com.wi.pb.forum.violationNotification.dto.SimpleMainPostDTO;
import org.mapstruct.Mapper;

@Mapper
public interface SimpleMainPostMapper extends SimpleMapper<SimpleMainPost, SimpleMainPostDTO> {
}
