package com.wi.pb.forum.auth;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration
@WebAppConfiguration
@Import(ControllersTest.SecuredController.class)
class ControllersTest {

    @MockBean
    private JavaMailSender javaMailSender;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
    }

    @Nested
    class SecuredEndpointsTest {

        @Test
        void test() throws Exception {
            mvc.perform(get(SecuredController.ENDPOINT)).andExpect(status().isForbidden());
        }

        @WithMockUser(roles="USER")
        @Test
        void endpointWhenUserAuthorityThenAuthorized() throws Exception {
            mvc.perform(get("/api/main-post"))
                    .andExpect(status().isOk());
        }

        @WithMockUser(roles = "USER")
        @Test
        void endpointWhenUserAuthorityThenForbidden() throws Exception {
            mvc.perform(delete("/api/main-post/1"))
                    .andExpect(status().isForbidden());
        }

        @WithMockUser(roles = "ADMIN")
        @Test
        void endpointWhenAdminAuthorityThenOK() throws Exception {
            mvc.perform(delete("/api/main-post/1"))
                    .andExpect(status().isOk());
        }

    }


    @RestController
    static class SecuredController {
        static final String ENDPOINT = "/api/hello";

        @RequestMapping(ENDPOINT)
        @Secured("ROLE_USER")
        public void hello() {

        }
    }
}
