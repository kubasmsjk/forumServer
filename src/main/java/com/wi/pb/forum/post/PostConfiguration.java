package com.wi.pb.forum.post;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class PostConfiguration {

    @Bean
    public CommentFacade commentFacade(CommentRepository commentRepository) {
        return new CommentFacade(
                new CommentService(commentRepository, Mappers.getMapper(CommentMapper.class))
        );
    }

    @Bean
    public MainPostFacade mainPostFacade(MainPostRepository mainPostRepository) {
        return new MainPostFacade(
                new MainPostService(
                        mainPostRepository, Mappers.getMapper(MainPostMapper.class)
                )
        );
    }
}
