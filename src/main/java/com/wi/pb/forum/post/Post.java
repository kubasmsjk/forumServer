package com.wi.pb.forum.post;

import com.wi.pb.forum.infrastructure.Identifiable;
import jakarta.persistence.*;

//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
class Post implements Identifiable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 10000)
    private String description;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "forum_user_id", referencedColumnName = "id")
    private ForumUser author;

    public Post() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long aLong) {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ForumUser getAuthor() {
        return author;
    }

    public void setAuthor(ForumUser author) {
        this.author = author;
    }
}
