package com.wi.pb.forum.email;

public interface EmailSender {
    void send(String to, String subject, String email);
}
