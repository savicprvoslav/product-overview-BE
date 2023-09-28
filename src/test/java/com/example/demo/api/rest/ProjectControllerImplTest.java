package com.example.demo.api.rest;

import com.example.demo.domain.services.ProjectService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProjectControllerImpl.class)
class ProjectControllerImplTest {

    @MockBean
    private ProjectService projectService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getProjects() throws Exception {
        when(projectService.getProjectsWithCounts(Mocks.PRODUCT_ID))
                .thenReturn(Mocks.PROJECTS_WITH_COUNTS);

        mockMvc.perform(get("/projects/{productId}", Mocks.PRODUCT_ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(Mocks.PROJECT_DTOs)))
                .andDo(print());
    }

    @Test
    void createProject() throws Exception {
        mockMvc.perform(post("/projects/{productId}", Mocks.PRODUCT_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(Mocks.CREATE_PROJECT_DTO)))
                .andExpect(status().isOk())
                .andDo(print());

        verify(projectService).saveProject(Mocks.CREATE_PROJECT_REQUEST);
    }
}
