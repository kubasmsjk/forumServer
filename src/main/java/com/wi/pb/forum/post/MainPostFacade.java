package com.wi.pb.forum.post;

import com.wi.pb.forum.infrastructure.SimpleFacade;
import com.wi.pb.forum.post.dto.CommentDTO;
import com.wi.pb.forum.post.dto.MainPostDTO;
import com.wi.pb.forum.post.dto.MainPostEditDTO;

import java.util.List;

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

    public void follow(Long id) {
        mainPostService.follow(id,true);
    }

    public void unfollow(Long id) {
        mainPostService.follow(id,false);
    }

    public List<MainPostDTO> findDtosById(Long id) {
        return mainPostService.findAllByMainPostId(id);
    }
}
