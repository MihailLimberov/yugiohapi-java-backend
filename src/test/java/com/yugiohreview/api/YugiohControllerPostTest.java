package com.yugiohreview.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class YugiohControllerPostTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createCard_success() throws Exception {
        String newCard = "{\"name\":\"Dark Magician\",\"attack\":2500,\"defense\":2100}";

        mockMvc.perform(post("/yugioh")
            .contentType(MediaType.APPLICATION_JSON)
            .content(newCard))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.name").value("Dark Magician"));
    }
}
