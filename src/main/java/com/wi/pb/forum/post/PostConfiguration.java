package com.wi.pb.forum.post;

import com.wi.pb.forum.user.ForumUserFacade;
import com.wi.pb.forum.user.ForumUserMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostConfiguration {

    @Bean
    public CommentFacade commentFacade(CommentRepository commentRepository) {
        return new CommentFacade(
                new CommentService(commentRepository, Mappers.getMapper(CommentMapper.class))
        );
    }
}
