package com.wi.pb.forum.violationNotification;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

@Immutable
@Table(name="Post")
@Entity(name = "ViolationNotificationPost")
class Post {

    @Id
    private Long id;
    private String description;
}
