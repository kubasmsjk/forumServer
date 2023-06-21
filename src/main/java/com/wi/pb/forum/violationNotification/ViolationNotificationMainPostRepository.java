package com.wi.pb.forum.violationNotification;

import org.springframework.data.jpa.repository.JpaRepository;

interface ViolationNotificationMainPostRepository extends JpaRepository<SimpleMainPost, Long> {
}
