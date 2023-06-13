package com.wi.pb.forum.post;

import com.wi.pb.forum.infrastructure.service.CrudService;
import com.wi.pb.forum.post.dto.MainPostDTO;
import org.springframework.data.jpa.repository.JpaRepository;

class MainPostService implements CrudService<MainPost, MainPostDTO, Long> {

    private final MainPostRepository mainPostRepository;
    private final MainPostMapper mainPostMapper;

    public MainPostService(MainPostRepository mainPostRepository,
                           MainPostMapper mainPostMapper) {
        this.mainPostRepository = mainPostRepository;
        this.mainPostMapper = mainPostMapper;
    }

    @Override
    public String getEntityName() {
        return MainPost.class.getName();
    }

    @Override
    public MainPost mapToEntity(MainPostDTO mainPostDTO) {
        return mainPostMapper.toEntity(mainPostDTO);
    }

    @Override
    public MainPostDTO mapToDto(MainPost entity) {
        return mainPostMapper.toDto(entity);
    }

    @Override
    public JpaRepository<MainPost, Long> getRepo() {
        return mainPostRepository;
    }
}
