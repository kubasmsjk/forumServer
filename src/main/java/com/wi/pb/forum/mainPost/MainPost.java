package com.wi.pb.forum.mainPost;

import com.wi.pb.forum.category.Category;
import com.wi.pb.forum.post.Post;
import com.wi.pb.forum.user.dto.ForumUserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="MainPost")
public class MainPost extends Post {

    private String title;
    private Category category;
    //private List<ForumUserDTO> viewers;

}
