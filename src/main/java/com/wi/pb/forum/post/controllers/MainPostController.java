package com.wi.pb.forum.post.controllers;

import com.wi.pb.forum.infrastructure.SimpleController;
import com.wi.pb.forum.post.MainPostFacade;
import com.wi.pb.forum.post.dto.MainPostDTO;
import com.wi.pb.forum.post.dto.MainPostEditDTO;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping
    public MainPostDTO update(@RequestBody MainPostEditDTO mainPostEditDTO){
        return mainPostFacade.update(mainPostEditDTO);
    }

}

