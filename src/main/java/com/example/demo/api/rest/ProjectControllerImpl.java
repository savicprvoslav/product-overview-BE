package com.example.demo.api.rest;

import com.example.demo.domain.entities.Project;
import com.example.demo.domain.services.ProjectService;
import com.example.demo.domain.services.ProjectService.CreateProjectRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class ProjectControllerImpl implements ProjectController {

    private final ProjectService projectService;

    public ProjectControllerImpl(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public Collection<ProjectDto> getProjects(UUID productId) {
        return projectService.getProjectsWithCounts(productId).stream().map(this::mapProjectToProjectDto).collect(Collectors.toList());
    }

    @Override
    public void createProject(CreateProjectDto projectDto, UUID productId) {
        projectService.saveProject(mapProjectDtoToCreateProjectRequest(projectDto, productId));
    }

    private ProjectDto mapProjectToProjectDto(Project project) {
        return new ProjectDto(project.getId(), project.getName(), project.getDescription(), project.getVoteCount());
    }

    private CreateProjectRequest mapProjectDtoToCreateProjectRequest(CreateProjectDto projectDto, UUID productId) {
        return new CreateProjectRequest(projectDto.getName(), projectDto.getDescription(), productId);
    }
}
