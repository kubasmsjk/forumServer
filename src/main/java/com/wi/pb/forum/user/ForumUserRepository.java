package com.wi.pb.forum.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ForumUserRepository extends JpaRepository<ForumUser, Long> {
    Optional<ForumUser> findByUsername(String username);

    @Query(nativeQuery = true,
            value = "SELECT EXISTS ( SELECT 1 FROM forum_user f WHERE f.username = :username)")
    boolean isUserExistByUsername(String username);
}
