package com.wi.pb.forum.violationNotification;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

import java.util.List;

@Immutable
@Table(name="MainPost")
@Entity(name = "ViolationNotificationMainPost")
class SimpleMainPost {

    @Id
    private Long id;
    private String description;
    private String title;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<ViolationNotification> violationNotifications;

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
}
