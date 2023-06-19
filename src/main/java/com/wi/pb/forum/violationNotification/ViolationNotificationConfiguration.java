package com.wi.pb.forum.violationNotification;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ViolationNotificationConfiguration {

    @Bean
    public ViolationNotificationFacade violationNotificationFacade(ViolationNotificationRepository violationNotificationRepository) {
        return new ViolationNotificationFacade(
                new ViolationNotificationService(violationNotificationRepository, Mappers.getMapper(ViolationNotificationMapper.class))
        );
    }

}
