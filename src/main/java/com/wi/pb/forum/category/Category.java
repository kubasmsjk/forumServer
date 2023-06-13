package com.wi.pb.forum.category;

import com.wi.pb.forum.infrastructure.Identifiable;
import jakarta.persistence.*;

@Entity
@Table(name="Category")
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

    public void String(String name) {
        this.name = name;
    }
}
