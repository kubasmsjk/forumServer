package com.wi.pb.forum.user.Controllers;


import com.wi.pb.forum.user.ForumUserFacade;
import com.wi.pb.forum.user.dto.ForumUserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class ForumUserController {
    private final ForumUserFacade forumUserFacade;

    public ForumUserController(ForumUserFacade forumUserFacade) {
        this.forumUserFacade = forumUserFacade;
    }

    @GetMapping
    public List<ForumUserDTO> getAllUsers() {
        return forumUserFacade.findAll();
    }

//    @PostMapping
//    public ForumUser createUser(@RequestBody ForumUser forumUser) {
//        return forumUserFacade.save(forumUser);
//    }

}
