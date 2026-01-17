package com.yugiohreview.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class YugiohValidationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createCard_missingName_shouldReturnBadRequest() throws Exception {
        String badJson = "{\"attack\":1000}";

        mockMvc.perform(post("/yugioh")
            .contentType(MediaType.APPLICATION_JSON)
            .content(badJson))
            .andExpect(status().isBadRequest());
    }
}
