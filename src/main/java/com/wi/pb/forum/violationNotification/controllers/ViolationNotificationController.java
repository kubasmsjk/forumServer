package com.wi.pb.forum.violationNotification.controllers;

import com.wi.pb.forum.infrastructure.SimpleController;
import com.wi.pb.forum.violationNotification.ViolationNotificationFacade;
import com.wi.pb.forum.violationNotification.dto.ViolationNotificationDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/violation-notification")
public class ViolationNotificationController implements SimpleController<ViolationNotificationDTO, Long> {
    private final ViolationNotificationFacade violationNotificationFacade;

    public ViolationNotificationController(ViolationNotificationFacade violationNotificationFacade) {
        this.violationNotificationFacade = violationNotificationFacade;
    }

    @Override
    public ViolationNotificationFacade getFacade() {
        return violationNotificationFacade;
    }
}
