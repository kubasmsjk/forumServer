package com.wi.pb.forum.post;

import com.wi.pb.forum.infrastructure.Identifiable;
import com.wi.pb.forum.user.dto.ForumUserDTO;
import jakarta.persistence.*;

@Entity
@Table(name="Post")
public class Post implements Identifiable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "form_user_id", referencedColumnName = "id")
//    private ForumUserDTO ForumUser;

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId(Long aLong) {

    }
}
