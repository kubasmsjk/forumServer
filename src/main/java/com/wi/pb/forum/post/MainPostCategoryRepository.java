package com.wi.pb.forum.post;

import org.springframework.data.jpa.repository.JpaRepository;

interface MainPostCategoryRepository extends JpaRepository<Category, Long> {
}
