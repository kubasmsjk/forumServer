package com.wi.pb.forum.user;


import com.wi.pb.forum.user.dto.ForumUserDTO;

import java.util.List;

public class ForumUserFacade {
    private final ForumUserService forumUserService;

    public ForumUserFacade(ForumUserService forumUserService) {
        this.forumUserService = forumUserService;
    }

    public List<ForumUserDTO> findAll() {
        return forumUserService.findAllDto();
    }
}
