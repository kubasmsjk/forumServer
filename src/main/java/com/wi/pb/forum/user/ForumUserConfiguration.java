package com.wi.pb.forum.user;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ForumUserConfiguration {

    @Bean
    public ForumUserFacade forumUserFacade(ForumUserRepository forumUserRepository,
                                            RoleRepository roleRepository) {
        ForumUserMapper forumUserMapper = Mappers.getMapper(ForumUserMapper.class);
        return new ForumUserFacade(
                new ForumUserService(forumUserRepository, forumUserMapper),
                new CreateForumUserCommandHandler(forumUserRepository, roleRepository, forumUserMapper)
        );
    }
}
