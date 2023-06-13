package com.wi.pb.forum.violationNotification;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.Immutable;

@Immutable
@Entity(name = "ViolationNotificationPost")
class Post {

    @Id
    private Long id;
    private String description;
}
