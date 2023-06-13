package com.wi.pb.forum.user;

import com.wi.pb.forum.infrastructure.SimpleFacade;
import com.wi.pb.forum.user.dto.CreateForumUserCommand;
import com.wi.pb.forum.user.dto.ForumUserDTO;

import java.util.List;

public class ForumUserFacade implements SimpleFacade<ForumUserDTO, Long> {

    private final ForumUserService forumUserService;
    private final CreateForumUserCommandHandler createForumUserCommandHandler;

    public ForumUserFacade(ForumUserService forumUserService,
                           CreateForumUserCommandHandler createForumUserCommandHandler) {
        this.forumUserService = forumUserService;
        this.createForumUserCommandHandler = createForumUserCommandHandler;
    }

    public List<ForumUserDTO> findAll() {
        return forumUserService.findAllDto();
    }

    @Override
    public ForumUserService getService() {
        return forumUserService;
    }


    public ForumUserDTO createUser(CreateForumUserCommand command) {
        return createForumUserCommandHandler.handle(command);
    }
}
