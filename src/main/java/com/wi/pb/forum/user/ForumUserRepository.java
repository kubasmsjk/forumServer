package com.wi.pb.forum.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ForumUserRepository extends JpaRepository<ForumUser, Long> {
}
