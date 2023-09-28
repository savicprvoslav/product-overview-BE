package com.example.demo.domain.services;

import com.example.demo.domain.services.ProjectService.CreateProjectRequest;
import com.example.demo.domain.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StartupApplication implements ApplicationListener<ApplicationStartedEvent> {
    @Autowired
    ProductService productService;

    @Autowired
    ProjectService projectService;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        UUID projectId1 = UUID.randomUUID();
        UUID projectId2 = UUID.randomUUID();
        UUID projectId3 = UUID.randomUUID();

        productService.saveProduct(new Product(projectId1, "Product 1"));
        productService.saveProduct(new Product(projectId2, "Product 2"));
        productService.saveProduct(new Product(projectId3, "Product 3"));

        projectService.saveProject(new CreateProjectRequest("Project 1", "Project 1 description", projectId1));
        projectService.saveProject(new CreateProjectRequest("Project 2", "Project 1 description", projectId1));
        projectService.saveProject(new CreateProjectRequest("Project 3", "Project 1 description", projectId1));
        projectService.saveProject(new CreateProjectRequest("Project 4", "Project 1 description", projectId1));
        projectService.saveProject(new CreateProjectRequest("Project 5", "Project 1 description", projectId1));


        projectService.saveProject(new CreateProjectRequest("Project 11", "Project 1 description", projectId2));
        projectService.saveProject(new CreateProjectRequest("Project 12", "Project 1 description", projectId2));
        projectService.saveProject(new CreateProjectRequest("Project 13", "Project 1 description", projectId2));
        projectService.saveProject(new CreateProjectRequest("Project 14", "Project 1 description", projectId2));
        projectService.saveProject(new CreateProjectRequest("Project 15", "Project 1 description", projectId2));
    }
}
