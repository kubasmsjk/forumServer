package com.wi.pb.forum.comment;

import com.wi.pb.forum.mainPost.MainPost;
import com.wi.pb.forum.post.Post;
import jakarta.persistence.*;

@Entity
@Table(name="Comment")
public class Comment extends Post {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "main_post_id", referencedColumnName = "id")
    private MainPost mainPost;

}
