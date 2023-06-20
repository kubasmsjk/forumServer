package com.wi.pb.forum.violationNotification;

import com.wi.pb.forum.infrastructure.Identifiable;
import jakarta.persistence.*;

@Entity
@Table(name="ViolationNotification")
class ViolationNotification implements Identifiable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "forum_user_id", referencedColumnName = "id")
    private ForumUser informer;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ForumUser getInformer() {
        return informer;
    }

    public void setInformer(ForumUser informer) {
        this.informer = informer;
    }
}
