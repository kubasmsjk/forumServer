package com.wi.pb.forum.violationNotification;

import com.wi.pb.forum.infrastructure.SimpleFacade;
import com.wi.pb.forum.violationNotification.dto.ViolationNotificationDTO;

public class ViolationNotificationFacade implements SimpleFacade<ViolationNotificationDTO, Long> {

    private final ViolationNotificationService violationNotificationService;
    private final CreateViolationNotificationCommandHandler createViolationNotificationCommandHandler;

    public ViolationNotificationFacade(ViolationNotificationService violationNotificationService,
                                       CreateViolationNotificationCommandHandler createViolationNotificationCommandHandler) {
        this.violationNotificationService = violationNotificationService;
        this.createViolationNotificationCommandHandler = createViolationNotificationCommandHandler;
    }

    @Override
    public ViolationNotificationService getService() {
        return violationNotificationService;
    }

    public ViolationNotificationDTO createViolationNotification(CreateViolationNotificationCommand command) {
        return createViolationNotificationCommandHandler.handle(command);
    }
}
