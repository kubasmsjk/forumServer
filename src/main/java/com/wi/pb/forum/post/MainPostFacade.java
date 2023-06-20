package com.wi.pb.forum.post;

import com.wi.pb.forum.infrastructure.SimpleFacade;
import com.wi.pb.forum.post.dto.MainPostDTO;
import com.wi.pb.forum.post.dto.MainPostEditDTO;

public class MainPostFacade implements SimpleFacade<MainPostDTO, Long> {

    private final MainPostService mainPostService;
    private final CreateMainPostCommandHandler createMainPostCommandHandler;

    public MainPostFacade(MainPostService mainPostService,
                          CreateMainPostCommandHandler createMainPostCommandHandler) {
        this.mainPostService = mainPostService;
        this.createMainPostCommandHandler = createMainPostCommandHandler;
    }

    @Override
    public MainPostService getService() {
        return mainPostService;
    }

    public MainPostDTO createMainPost(CreateMainPostCommand command) {
        return createMainPostCommandHandler.handle(command);
    }

    public MainPostDTO update(MainPostEditDTO mainPostEditDTO) {
        return mainPostService.update(mainPostEditDTO);
    }
}
