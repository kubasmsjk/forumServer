package com.wi.pb.forum.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ForumUserRepository extends JpaRepository<ForumUser, Long> {
    Optional<ForumUser> findByUsername(String username);
}
