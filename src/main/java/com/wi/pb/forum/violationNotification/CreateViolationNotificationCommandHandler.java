package com.wi.pb.forum.violationNotification;

import com.wi.pb.forum.violationNotification.dto.ViolationNotificationDTO;

public class CreateViolationNotificationCommandHandler {
    private final ViolationNotificationRepository violationNotificationRepository;
    private final ViolationNotificationForumUserRepository violationNotificationForumUserRepository;
    private final ViolationNotificationMainPostRepository violationNotificationMainPostRepository;
    private final ViolationNotificationMapper violationNotificationMapper;

    public CreateViolationNotificationCommandHandler(ViolationNotificationRepository violationNotificationRepository,
                                                     ViolationNotificationForumUserRepository violationNotificationForumUserRepository,
                                                     ViolationNotificationMainPostRepository violationNotificationMainPostRepository,
                                                     ViolationNotificationMapper violationNotificationMapper) {
        this.violationNotificationRepository = violationNotificationRepository;
        this.violationNotificationForumUserRepository = violationNotificationForumUserRepository;
        this.violationNotificationMainPostRepository = violationNotificationMainPostRepository;
        this.violationNotificationMapper = violationNotificationMapper;
    }

    public ViolationNotificationDTO handle(CreateViolationNotificationCommand command) {
        ViolationNotification violationNotification = new ViolationNotification();
        mapCommandToViolationNotification(command, violationNotification);

        ViolationNotification savedViolationNotification = violationNotificationRepository.save(violationNotification);
        return violationNotificationMapper.toDto(savedViolationNotification);
    }

    private void mapCommandToViolationNotification(CreateViolationNotificationCommand command,
                                                   ViolationNotification violationNotification) {

        ForumUser informer = violationNotificationForumUserRepository.findById(command.getInformerId()).orElseThrow(() -> new RuntimeException("Cannot find user"));
        SimpleMainPost post = violationNotificationMainPostRepository.findById(command.getPostId()).orElseThrow(() -> new RuntimeException("Cannot find post"));

        violationNotification.setPost(post);
        violationNotification.setDescription(command.getDescription());
        violationNotification.setInformer(informer);
    }
}
