package com.wi.pb.forum.post.controllers;

import com.wi.pb.forum.infrastructure.SimpleController;
import com.wi.pb.forum.post.MainPostFacade;
import com.wi.pb.forum.post.dto.MainPostDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/main-post")
public class MainPostController implements SimpleController<MainPostDTO, Long> {

    private final MainPostFacade mainPostFacade;

    public MainPostController(MainPostFacade mainPostFacade) {
        this.mainPostFacade = mainPostFacade;
    }

    @Override
    public MainPostFacade getFacade() {
        return mainPostFacade;
    }

}
