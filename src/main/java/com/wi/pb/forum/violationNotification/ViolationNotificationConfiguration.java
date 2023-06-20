package com.wi.pb.forum.violationNotification;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ViolationNotificationConfiguration {

    @Bean
    public ViolationNotificationFacade violationNotificationFacade(ViolationNotificationRepository violationNotificationRepository,
                                                                   ViolationNotificationForumUserRepository violationNotificationForumUserRepository,
                                                                   PostRepository postRepository) {
        ViolationNotificationMapper violationNotificationMapper = Mappers.getMapper(ViolationNotificationMapper.class);
        return new ViolationNotificationFacade(
                new ViolationNotificationService(violationNotificationRepository,
                        violationNotificationMapper),
                new CreateViolationNotificationCommandHandler(violationNotificationRepository,
                         violationNotificationForumUserRepository,
                         postRepository,
                        violationNotificationMapper)
        );
    }

}
