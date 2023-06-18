package com.wi.pb.forum.post;

import com.wi.pb.forum.email.EmailSender;
import com.wi.pb.forum.email.EmailTemplate;
import com.wi.pb.forum.infrastructure.service.CrudService;
import com.wi.pb.forum.post.dto.MainPostDTO;
import com.wi.pb.forum.post.dto.MainPostEditDTO;
import org.springframework.data.jpa.repository.JpaRepository;

class MainPostService implements CrudService<MainPost, MainPostDTO, Long> {

    private final MainPostRepository mainPostRepository;
    private final MainPostMapper mainPostMapper;
    private final EmailSender emailSender;

    public MainPostService(MainPostRepository mainPostRepository,
                           MainPostMapper mainPostMapper,
                           EmailSender emailSender) {
        this.mainPostRepository = mainPostRepository;
        this.mainPostMapper = mainPostMapper;
        this.emailSender = emailSender;
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

    public MainPostDTO update(MainPostEditDTO mainPostEditDTO) {
        MainPost mainPost = mainPostRepository.getReferenceById(mainPostEditDTO.getId());

        mainPost.setTitle(mainPostEditDTO.getTitle());
        mainPost.setDescription(mainPostEditDTO.getDescription());
        MainPost savedMainPost = mainPostRepository.save(mainPost);

        sendEmail(mainPost);

        return mapToDto(savedMainPost);
    }

    public void sendEmail(MainPost mainPost){
        String linkToPost = "https://pb.edu.pl/";
        for (ForumUser viewer : mainPost.getViewers()) {
            emailSender.send(viewer.getEmail(),  "News in: " + mainPost.getTitle(),
                    EmailTemplate.buildEmail(viewer.getUsername(),linkToPost));
        }
    }

}

