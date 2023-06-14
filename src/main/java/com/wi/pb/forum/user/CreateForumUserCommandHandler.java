package com.wi.pb.forum.user;

import com.wi.pb.forum.user.dto.CreateForumUserCommand;
import com.wi.pb.forum.user.dto.ForumUserDTO;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CreateForumUserCommandHandler {
    private final ForumUserRepository forumUserRepository;
    private final RoleRepository roleRepository;
    private final ForumUserMapper forumUserMapper;

    public CreateForumUserCommandHandler(ForumUserRepository forumUserRepository, RoleRepository roleRepository, ForumUserMapper forumUserMapper) {
        this.forumUserRepository = forumUserRepository;
        this.roleRepository = roleRepository;
        this.forumUserMapper = forumUserMapper;
    }

    public ForumUserDTO handle(CreateForumUserCommand command) {
        ForumUser forumUser = new ForumUser();
        mapCommandToUser(command, forumUser);

        ForumUser savedUser = forumUserRepository.save(forumUser);
        return forumUserMapper.toDto(savedUser);
    }

    private void mapCommandToUser(CreateForumUserCommand command, ForumUser forumUser) {
        Set<Role> roles = new HashSet<>(roleRepository.findAllById(command.getRolesIds()));
        forumUser.setRoles(roles);
        forumUser.setEmail(command.getEmail());
        forumUser.setUsername(command.getUsername());
        forumUser.setPassword(command.getPassword());
    }
}
