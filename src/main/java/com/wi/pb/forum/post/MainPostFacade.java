package com.wi.pb.forum.post;

import com.wi.pb.forum.infrastructure.SimpleFacade;
import com.wi.pb.forum.post.dto.MainPostDTO;

public class MainPostFacade implements SimpleFacade<MainPostDTO, Long> {

    private final MainPostService mainPostService;

    public MainPostFacade(MainPostService mainPostService) {
        this.mainPostService = mainPostService;
    }

    @Override
    public MainPostService getService() {
        return mainPostService;
    }
}
