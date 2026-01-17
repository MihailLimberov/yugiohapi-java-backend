package com.yugiohreview.api;

import com.yugiohreview.api.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testRegisterAndLogin() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("1234");

        ResponseEntity<String> registerResponse = restTemplate.postForEntity("/auth/register", user, String.class);
        assertEquals("User registered", registerResponse.getBody());

        ResponseEntity<String> loginResponse = restTemplate.postForEntity("/auth/login", user, String.class);
        assertEquals("Login successful", loginResponse.getBody());
    }
}
