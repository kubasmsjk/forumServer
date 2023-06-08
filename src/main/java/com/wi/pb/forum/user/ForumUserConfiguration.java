package com.wi.pb.forum.user;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ForumUserConfiguration {

    @Bean
    public ForumUserFacade forumUserFacade(ForumUserRepository forumUserRepository) {
        return new ForumUserFacade(
                new ForumUserService(forumUserRepository, Mappers.getMapper(ForumUserMapper.class))
        );
    }
}
