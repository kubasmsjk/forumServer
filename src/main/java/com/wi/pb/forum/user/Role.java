package com.wi.pb.forum.user;

public enum Role {

    USER("USER"),
    ADMIN("ADMIN");

    private String name;

    Role(String name) {
        this.name = name;
    }
}
