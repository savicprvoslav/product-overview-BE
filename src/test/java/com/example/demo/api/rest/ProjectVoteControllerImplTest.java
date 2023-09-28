package com.example.demo.api.rest;

import com.example.demo.domain.services.ProjectVoteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@WebMvcTest(ProjectVoteControllerImpl.class)
class ProjectVoteControllerImplTest {

    @MockBean
    private ProjectVoteService projectVoteService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void voteForProject() throws Exception{
        mockMvc.perform(put("/projects/{projectId}/vote", Mocks.PROJECT_ID))
                .andExpect(status().isOk())
                .andDo(print());

        verify(projectVoteService).vote(Mocks.PROJECT_ID);
    }
}
