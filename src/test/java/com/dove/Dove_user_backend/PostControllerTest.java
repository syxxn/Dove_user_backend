package com.dove.Dove_user_backend;

import com.dove.Dove_user_backend.dto.request.PostRequest;
import com.dove.Dove_user_backend.entity.post.PostRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DoveUserBackendApplication.class)
@ActiveProfiles({"test"})
class PostControllerTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private PostRepository postRepository;

    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @AfterEach
    public void deleteAll() {
        postRepository.deleteAll();
    }

    @Test
    public void writePost() throws Exception {
        PostRequest postRequest = PostRequest.builder()
                .host("host")
                .writer("writer")
                .title("title")
                .description("description")
                .eventDate("2020-02-19")
                .link("link")
                .build();

        mvc.perform(post("/user/post")
                .content(new ObjectMapper()
                        .writeValueAsString(postRequest))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated());
    }

}
