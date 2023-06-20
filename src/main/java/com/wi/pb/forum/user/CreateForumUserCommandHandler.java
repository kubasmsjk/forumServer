package com.wi.pb.forum.user;

import com.wi.pb.forum.user.dto.CreateForumUserCommand;
import com.wi.pb.forum.user.dto.ForumUserDTO;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CreateForumUserCommandHandler {
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
