package com.wi.pb.forum.user;

import com.wi.pb.forum.auth.AuthenticationService;
import com.wi.pb.forum.config.JwtService;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
class ForumUserConfiguration {

    private final ForumUserRepository forumUserRepository;
    private final JwtService jwtService;

    ForumUserConfiguration(ForumUserRepository forumUserRepository, JwtService jwtService) {
        this.forumUserRepository = forumUserRepository;
        this.jwtService = jwtService;
    }

    @Bean
    public ForumUserFacade forumUserFacade(RoleRepository roleRepository) {
        ForumUserMapper forumUserMapper = Mappers.getMapper(ForumUserMapper.class);
        return new ForumUserFacade(
                new ForumUserService(forumUserRepository, forumUserMapper),
                new CreateForumUserCommandHandler(forumUserRepository, roleRepository, forumUserMapper)
        );
    }


    @Bean
    public AuthenticationService authenticationService(PasswordEncoder passwordEncoder,
                                                       AuthenticationManager authenticationManager) {
        return new AuthenticationService(forumUserRepository,
                jwtService, passwordEncoder, authenticationManager);
    }
}
