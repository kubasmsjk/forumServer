package com.wi.pb.forum.post;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByMainPostId(Long id);
}
