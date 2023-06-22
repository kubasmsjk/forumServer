package com.wi.pb.forum.auth;

import com.wi.pb.forum.config.JwtService;
import com.wi.pb.forum.user.ForumUser;
import com.wi.pb.forum.user.ForumUserRepository;
import com.wi.pb.forum.user.Role;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthenticationService {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class.getName());
    private final ForumUserRepository forumUserRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(ForumUserRepository forumUserRepository, JwtService jwtService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.forumUserRepository = forumUserRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(RegisterRequest request) {
        boolean exist = forumUserRepository.isUserExistByUsername(request.getUsername());
        if (exist) {
            logger.error(String.format("User with username: %s already exist.", request.getUsername()));
            throw new IllegalArgumentException(String.format("User with username: %s already exist.", request.getUsername()));
        }
        ForumUser user = new ForumUser();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);
        forumUserRepository.save(user);
        String jwtToken  = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        ForumUser user = forumUserRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Could not find user"));
        String jwtToken  = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }

    public void refreshToken(HttpServletRequest request, HttpServletResponse response) {

    }
}
