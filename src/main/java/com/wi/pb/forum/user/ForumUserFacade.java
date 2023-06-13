package com.wi.pb.forum.user;


import com.wi.pb.forum.infrastructure.SimpleFacade;
import com.wi.pb.forum.user.dto.ForumUserDTO;

import java.util.List;

public class ForumUserFacade implements SimpleFacade<ForumUserDTO, Long> {
    private final ForumUserService forumUserService;

    public ForumUserFacade(ForumUserService forumUserService) {
        this.forumUserService = forumUserService;
    }

    public List<ForumUserDTO> findAll() {
        return forumUserService.findAllDto();
    }

    @Override
    public ForumUserService getService() {
        return forumUserService;
    }
}
