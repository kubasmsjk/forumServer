package com.wi.pb.forum.violationNotification;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

import java.util.Set;

@Immutable
@Table(name="MainPost")
@Entity(name = "ViolationNotificationMainPost")
class MainPost   {

    @Id
    private Long id;
    private String description;
    private String title;

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
