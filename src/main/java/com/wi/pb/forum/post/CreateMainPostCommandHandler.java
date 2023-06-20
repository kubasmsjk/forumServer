package com.wi.pb.forum.post;

import com.wi.pb.forum.post.dto.MainPostDTO;

public class CreateMainPostCommandHandler {

    private final MainPostRepository mainPostRepository;
    private final MainPostForumUserRepository mainPostForumUserRepository;
    private final MainPostCategoryRepository mainPostCategoryRepository;
    private final MainPostMapper mainPostMapper;


    public CreateMainPostCommandHandler(MainPostRepository mainPostRepository,
                                        MainPostForumUserRepository mainPostForumUserRepository,
                                        MainPostCategoryRepository mainPostCategoryRepository,
                                        MainPostMapper mainPostMapper) {
        this.mainPostRepository = mainPostRepository;
        this.mainPostForumUserRepository = mainPostForumUserRepository;
        this.mainPostCategoryRepository = mainPostCategoryRepository;
        this.mainPostMapper = mainPostMapper;
    }

    public MainPostDTO handle(CreateMainPostCommand command) {
        MainPost mainPost = new MainPost();
        mapCommandToViolationNotification(command, mainPost);

        MainPost savedMainPost = mainPostRepository.save(mainPost);
        return mainPostMapper.toDto(savedMainPost);
    }

    private void mapCommandToViolationNotification(CreateMainPostCommand command,
                                                   MainPost mainPost) {

        ForumUser author = mainPostForumUserRepository.findById(command.getAuthorId()).orElseThrow(() -> new RuntimeException("Cannot find user"));
        Category category = mainPostCategoryRepository.findById(command.getCategoryId()).orElseThrow(() -> new RuntimeException("Cannot find category"));

        mainPost.setTitle(command.getTitle());
        mainPost.setDescription(command.getDescription());
        mainPost.setCategory(category);
        mainPost.setViewers(command.getViewers());
        mainPost.setAuthor(author);

    }

}
