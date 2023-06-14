package com.wi.pb.forum.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ForumUserRepository forumUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ForumUser forumUser = forumUserRepository.findByUsername(username);

        if (forumUser == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new ForumUserDetails(forumUser);
    }
}
