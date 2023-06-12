package com.wi.pb.forum.post;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

@Immutable
@Table(name="Category")
@Entity(name = "CategoryPost")
class Category {
    @Id
    private Long id;
    private String name;

    public Category() {

    }

    public Long getId() {
        return id;
    }

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
