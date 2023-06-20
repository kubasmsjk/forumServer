package com.wi.pb.forum.auth;

import com.wi.pb.forum.config.JwtService;
import com.wi.pb.forum.user.ForumUser;
import com.wi.pb.forum.user.ForumUserRepository;
import com.wi.pb.forum.user.Role;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

public class AuthenticationService {

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
        var user = new ForumUser();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);
        forumUserRepository.save(user);
        var jwtToken  = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = forumUserRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Could not find user"));
        var jwtToken  = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }

    public void refreshToken(HttpServletRequest request, HttpServletResponse response) {

    }
}
