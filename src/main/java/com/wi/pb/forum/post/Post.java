package com.wi.pb.forum.post;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Post {
    @Id
    private Long id;
}
