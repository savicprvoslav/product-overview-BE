package com.example.demo.api.rest;

import com.example.demo.domain.services.ProjectVoteService;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ProjectVoteControllerImpl implements ProjectVoteController {

    private final ProjectVoteService projectVoteService;

    public ProjectVoteControllerImpl(ProjectVoteService projectVoteService) {
        this.projectVoteService = projectVoteService;
    }

    @Override
    public void voteForProject(UUID projectId) {
        projectVoteService.vote(projectId);
    }
}
