package com.wi.pb.forum.post;

import org.springframework.data.jpa.repository.JpaRepository;

interface CommentRepository extends JpaRepository<Comment, Long> {
}
