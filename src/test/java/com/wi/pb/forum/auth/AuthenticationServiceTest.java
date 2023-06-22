package com.wi.pb.forum.auth;

import com.wi.pb.forum.config.JwtService;
import com.wi.pb.forum.user.ForumUserRepository;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AuthenticationServiceTest {

    @MockBean
    private JavaMailSender javaMailSender;
    @Resource
    private ForumUserRepository userRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    private AuthenticationService authService;
    private RegisterRequest request = new RegisterRequest();

    @BeforeAll
    void setup(){
        authService = new AuthenticationService(
                userRepository,
                jwtService,
                new BCryptPasswordEncoder(),
                authenticationManager
        );


        request.setUsername("username");
        request.setEmail("email@email.com");
        request.setPassword("password");

        authService.register(request);
    }

    @Test
    void registeringTwoUsersWithSameUsername_shouldThrowException() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class ,
                ()-> authService.register(request),
                "Another exception was thrown or it is possible to create two users with same username");
    }



    @Test
    void authenticationOnExistingUserWithBadCredentials_shouldReturnBearerToken() {
        //given
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setUsername("username");
        authenticationRequest.setPassword("bad!password!");

        //then
        Assertions.assertThrowsExactly(BadCredentialsException.class,
                //when
                ()-> authService.authenticate(authenticationRequest));
    }

    @Test
    void authenticationOnExistingUserWithCorrectCredentials_shouldReturnBearerToken() {
        //given
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setUsername("username");
        authenticationRequest.setPassword("password");

        //when
        AuthenticationResponse response = authService.authenticate(authenticationRequest);

        //then
        Assertions.assertNotNull(response.getToken());
        Assertions.assertNotEquals("", response.getToken());
        Assertions.assertEquals("ey", response.getToken().substring(0,2));
    }
}