package com.wi.pb.forum.auth;

import com.wi.pb.forum.config.JwtService;
import com.wi.pb.forum.user.ForumUserRepository;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@ExtendWith(SpringExtension.class)
@SpringBootTest
class AuthenticationServiceTest {

    @MockBean
    private JavaMailSender javaMailSender;
    @Resource
    private ForumUserRepository userRepository;

    @Test
    void registeringTwoUsersWithSameUsername_shouldThrowException() {
        RegisterRequest request = new RegisterRequest();
        request.setUsername("username");
        request.setEmail("email@email.com");
        request.setPassword("password");

        AuthenticationService authService = new AuthenticationService(
                userRepository,
                Mockito.mock(JwtService.class),
                new BCryptPasswordEncoder(),
                Mockito.mock(AuthenticationManager.class)
        );
        authService.register(request);

        Assertions.assertThrowsExactly(IllegalArgumentException.class ,
                ()-> authService.register(request),
                "Another exception was thrown or it is possible to create two users with same username");
    }

    @Test
    void authenticate() {
    }
}