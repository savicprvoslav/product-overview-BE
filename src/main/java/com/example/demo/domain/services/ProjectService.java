package com.example.demo.domain.services;

import com.example.demo.domain.entities.Project;
import com.example.demo.domain.exceptions.NotFoundException;
import com.example.demo.repository.entities.ProjectEntity;
import com.example.demo.repository.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;


@Service
public class ProjectService {

    private ProjectVoteService projectVoteService;
    private ProjectRepository projectRepository;

    private ProductService productService;

    private static Logger logger = LoggerFactory.getLogger(ProjectService.class);

    public ProjectService(ProjectVoteService projectVoteService, ProjectRepository projectRepository, ProductService productService) {
          this.projectVoteService = projectVoteService;
          this.projectRepository = projectRepository;
          this.productService = productService;
     }

    public void saveProject(CreateProjectRequest request) {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId(UUID.randomUUID());
        projectEntity.setName(request.getName());
        projectEntity.setDescription(request.getDescription());
        projectEntity.setProductId(request.getProductId());
        projectRepository.save(projectEntity);
    }

    @AllArgsConstructor
    @Data
    @EqualsAndHashCode
    public static class CreateProjectRequest {
        private String name;
        private String description;
        private UUID productId;
    }

    public Collection<Project> getProjectsWithCounts(UUID productId) {
        if(productService.getProductById(productId).isEmpty()) throw new NotFoundException("Product not found");

        Collection<ProjectEntity> projects = projectRepository.findProjectByProductId(productId);

        Map<UUID, Integer> projectVoteCountByProjectId = projectVoteService.getVotesForProjects(projects.stream().map(ProjectEntity::getId).toList());


        return projects.stream().map(projectEntity -> {
            Project project = new Project();
            project.setId(projectEntity.getId());
            project.setName(projectEntity.getName());
            project.setDescription(projectEntity.getDescription());
            project.setProductId(projectEntity.getProductId());
            project.setVoteCount(projectVoteCountByProjectId.getOrDefault(projectEntity.getId(), 0));

            logger.atInfo().log("projectVoteCountByProjectId: {}", projectVoteCountByProjectId.getOrDefault(projectEntity.getId(), 0));

            return project;
        }).toList();
    }
}
