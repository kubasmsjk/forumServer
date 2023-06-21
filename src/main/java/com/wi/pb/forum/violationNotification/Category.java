package com.wi.pb.forum.violationNotification;

import com.wi.pb.forum.infrastructure.Identifiable;
import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

@Immutable
@Table(name="ForumCategory")
@Entity(name = "ViolationNotificationCategory")
class Category implements Identifiable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
