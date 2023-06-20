package com.wi.pb.forum.violationNotification.controllers;

import com.wi.pb.forum.violationNotification.CreateViolationNotificationCommand;
import com.wi.pb.forum.violationNotification.ViolationNotificationFacade;
import com.wi.pb.forum.violationNotification.dto.ViolationNotificationDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/violation-notification")
public class ViolationNotificationController {
    private final ViolationNotificationFacade violationNotificationFacade;

    public ViolationNotificationController(ViolationNotificationFacade violationNotificationFacade) {
        this.violationNotificationFacade = violationNotificationFacade;
    }

    @GetMapping
    public List<ViolationNotificationDTO> getAllEntities(){
        return violationNotificationFacade.findAllDto();
    }

    @GetMapping("/{id}")
    public Optional<ViolationNotificationDTO> getEntityById(@PathVariable Long id){
        return violationNotificationFacade.findDtoById(id);
    }

    @PostMapping
    public ViolationNotificationDTO addEntity(@Valid @RequestBody CreateViolationNotificationCommand command) {
        return violationNotificationFacade.createViolationNotification(command);
    }

    @DeleteMapping("/{id}")
    public void deleteEntityById(@PathVariable Long id) {
        violationNotificationFacade.deleteById(id);
    }
}
