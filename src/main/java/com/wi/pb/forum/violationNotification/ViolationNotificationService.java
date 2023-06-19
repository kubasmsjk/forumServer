package com.wi.pb.forum.violationNotification;

import com.wi.pb.forum.infrastructure.service.CrudService;
import com.wi.pb.forum.violationNotification.dto.ViolationNotificationDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public class ViolationNotificationService implements CrudService<ViolationNotification, ViolationNotificationDTO, Long> {
    private final ViolationNotificationRepository violationNotificationRepository;
    private final ViolationNotificationMapper violationNotificationMapper;

    public ViolationNotificationService(ViolationNotificationRepository violationNotificationRepository,
                                        ViolationNotificationMapper violationNotificationMapper) {
        this.violationNotificationRepository = violationNotificationRepository;
        this.violationNotificationMapper = violationNotificationMapper;
    }

    @Override
    public JpaRepository<ViolationNotification, Long> getRepo() {
        return violationNotificationRepository;
    }

    @Override
    public String getEntityName() {
        return ViolationNotification.class.getName();
    }

    @Override
    public ViolationNotification mapToEntity(ViolationNotificationDTO violationNotificationDTO) {
        return violationNotificationMapper.toEntity(violationNotificationDTO);
    }

    @Override
    public ViolationNotificationDTO mapToDto(ViolationNotification entity) {
        return violationNotificationMapper.toDto(entity);
    }
}
