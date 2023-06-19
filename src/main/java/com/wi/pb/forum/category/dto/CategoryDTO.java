package com.wi.pb.forum.category.dto;

import com.wi.pb.forum.infrastructure.Identifiable;

public class CategoryDTO implements Identifiable<Long> {

    private Long id;
    private String name;

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
