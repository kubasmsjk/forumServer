package com.wi.pb.forum.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class SecurityUtil {

    private SecurityUtil() {
    }

    public static String getCurrentUserNameOrEmptyString(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = Optional.ofNullable(authentication.getName()).orElse("");

        return userName;
    }
}
