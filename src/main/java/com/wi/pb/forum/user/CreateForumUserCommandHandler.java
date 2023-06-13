package com.wi.pb.forum.user;

import com.wi.pb.forum.user.dto.CreateForumUserCommand;
import com.wi.pb.forum.user.dto.ForumUserDTO;

public class CreateForumUserCommandHandler {
    private final ForumUserRepository forumUserRepository;
    private final ForumUserMapper forumUserMapper;

    public CreateForumUserCommandHandler(ForumUserRepository forumUserRepository, ForumUserMapper forumUserMapper) {
        this.forumUserRepository = forumUserRepository;
        this.forumUserMapper = forumUserMapper;
    }

    public ForumUserDTO handle(CreateForumUserCommand command) {
        ForumUser forumUser = new ForumUser();
        mapCommandToUser(command, forumUser);

        ForumUser savedUser = forumUserRepository.save(forumUser);
        return forumUserMapper.toDto(savedUser);
    }

    private static void mapCommandToUser(CreateForumUserCommand command, ForumUser forumUser) {
        forumUser.setRole(command.getRole());
        forumUser.setEmail(command.getEmail());
        forumUser.setUsername(command.getUsername());
        forumUser.setPassword(command.getPassword());
    }
}
