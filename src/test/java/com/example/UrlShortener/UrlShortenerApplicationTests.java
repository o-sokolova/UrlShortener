package com.example.UrlShortener;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class UrlShortenerApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void helloTest() throws Exception {
        this.mockMvc.perform(get("/hellourl?name=world"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, world"));
    }

    @Test
    void shortTest() throws Exception {
        this.mockMvc.perform(post("/shorturl")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"longUrl\":\"https://start.spring.io/\"}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("shortUrl").value("http://localhost:0/68eb0a43"));
    }

    @BeforeTestMethod("redirectTest")

    @Test
    void redirectTest() throws Exception {
        this.mockMvc.perform(post("/shorturl")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"longUrl\":\"https://start.spring.io/\"}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());

        this.mockMvc.perform(get("/68eb0a43"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is(301))
                .andExpect(header().string("Location", "https://start.spring.io/"));
    }
}