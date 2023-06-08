package com.wi.pb.forum.user;

import com.wi.pb.forum.infrastructure.CycleAvoidingMappingContext;
import com.wi.pb.forum.infrastructure.service.CrudService;
import com.wi.pb.forum.user.dto.ForumUserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

class ForumUserService implements CrudService<ForumUser, ForumUserDTO, Long> {
    private final ForumUserRepository forumUserRepository;
    private final ForumUserMapper forumUserMapper;


    public ForumUserService(ForumUserRepository forumUserRepository,
                            ForumUserMapper forumUserMapper) {
        this.forumUserRepository = forumUserRepository;
        this.forumUserMapper = forumUserMapper;
    }

    @Override
    public JpaRepository<ForumUser, Long> getRepo() {
        return forumUserRepository;
    }

    @Override
    public String getEntityName() {
        return ForumUser.class.getName();
    }

    @Override
    public ForumUser mapToEntity(ForumUserDTO forumUserDTO) {
        return forumUserMapper.toEntity(forumUserDTO, new CycleAvoidingMappingContext());
    }

    @Override
    public ForumUserDTO mapToDto(ForumUser entity) {
        return forumUserMapper.toDto(entity, new CycleAvoidingMappingContext());
    }
}
