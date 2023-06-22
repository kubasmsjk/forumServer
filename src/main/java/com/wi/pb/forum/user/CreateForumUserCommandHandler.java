package com.wi.pb.forum.user;

import com.wi.pb.forum.ForumApplication;
import com.wi.pb.forum.user.dto.CreateForumUserCommand;
import com.wi.pb.forum.user.dto.ForumUserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CreateForumUserCommandHandler {
    private static final Logger logger = LoggerFactory.getLogger(CreateForumUserCommandHandler.class.getName());
    private final ForumUserRepository forumUserRepository;
    private final ForumUserMapper forumUserMapper;
    private final PasswordEncoder passwordEncoder;

    public CreateForumUserCommandHandler(ForumUserRepository forumUserRepository,
                                         ForumUserMapper forumUserMapper,
                                         PasswordEncoder passwordEncoder) {
        this.forumUserRepository = forumUserRepository;
        this.forumUserMapper = forumUserMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public ForumUserDTO handle(CreateForumUserCommand command) {
        if (forumUserRepository.isUserExistByUsername(command.getUsername())) {
            logger.error(String.format("User with username: %s already exist.", command.getUsername()));
            throw new IllegalStateException(String.format("User with username: %s already exist.", command.getUsername()));
        }
        ForumUser forumUser = new ForumUser();
        mapCommandToUser(command, forumUser);

        ForumUser savedUser = forumUserRepository.save(forumUser);
        return forumUserMapper.toDto(savedUser);
    }

    private void mapCommandToUser(CreateForumUserCommand command, ForumUser forumUser) {
        forumUser.setRole(command.getRole());
        forumUser.setEmail(command.getEmail());
        forumUser.setUsername(command.getUsername());
        forumUser.setPassword(passwordEncoder.encode(command.getPassword()));
    }
}
