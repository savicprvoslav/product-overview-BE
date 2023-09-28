package com.example.demo.api.rest;

import jdk.jfr.Frequency;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/projects/{productId}")
public interface ProjectController {
    @GetMapping
    Collection<ProjectDto> getProjects(@PathVariable UUID productId);

    @PostMapping
    void createProject(@RequestBody CreateProjectDto projectDto, @PathVariable UUID productId);

    @AllArgsConstructor
    @Data
    class CreateProjectDto {
        private String name;
        private String description;
    }

    @Data
    @AllArgsConstructor
    class ProjectDto {

        private UUID id;

        private String name;

        private String description;

        private Integer voteCount;
    }
}
