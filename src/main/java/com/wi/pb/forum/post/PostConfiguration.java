package com.wi.pb.forum.post;

import com.wi.pb.forum.email.EmailSender;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class PostConfiguration {

    @Autowired
    private EmailSender emailSender;

    @Bean
    public CommentFacade commentFacade(CommentRepository commentRepository) {
        return new CommentFacade(
                new CommentService(commentRepository, Mappers.getMapper(CommentMapper.class))
        );
    }

    @Bean
    public MainPostFacade mainPostFacade(MainPostRepository mainPostRepository,
                                         MainPostForumUserRepository mainPostForumUserRepository,
                                         MainPostCategoryRepository mainPostCategoryRepository) {
        MainPostMapper mainPostMapper=Mappers.getMapper(MainPostMapper.class);
        return new MainPostFacade(
                new MainPostService(
                        mainPostRepository, mainPostMapper,
                        emailSender, mainPostForumUserRepository),
                new CreateMainPostCommandHandler(mainPostRepository,
                        mainPostForumUserRepository,
                        mainPostCategoryRepository,
                        mainPostMapper)
        );
    }
}
