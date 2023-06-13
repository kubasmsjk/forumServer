package com.wi.pb.forum.user.controllers;


import com.wi.pb.forum.infrastructure.SimpleController;
import com.wi.pb.forum.user.ForumUserFacade;
import com.wi.pb.forum.user.dto.ForumUserDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class ForumUserController implements SimpleController<ForumUserDTO, Long> {
    private final ForumUserFacade forumUserFacade;

    public ForumUserController(ForumUserFacade forumUserFacade) {
        this.forumUserFacade = forumUserFacade;
    }

    @Override
    public ForumUserFacade getFacade() {
        return forumUserFacade;
    }

}
