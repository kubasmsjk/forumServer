package com.wi.pb.forum.violationNotification;

import com.wi.pb.forum.infrastructure.SimpleFacade;
import com.wi.pb.forum.violationNotification.dto.ViolationNotificationDTO;

public class ViolationNotificationFacade implements SimpleFacade<ViolationNotificationDTO, Long> {

    private final ViolationNotificationService violationNotificationService;

    public ViolationNotificationFacade(ViolationNotificationService violationNotificationService) {
        this.violationNotificationService = violationNotificationService;
    }

    @Override
    public ViolationNotificationService getService() {
        return violationNotificationService;
    }

}
