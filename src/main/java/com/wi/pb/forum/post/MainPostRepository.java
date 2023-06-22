package com.wi.pb.forum.post;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface MainPostRepository extends JpaRepository<MainPost, Long> {

    List<MainPost> findAllByAuthorId(Long id);
}
