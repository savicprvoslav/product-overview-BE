package com.example.demo.domain.services;

import com.example.demo.repository.projections.ProjectToCount;
import com.example.demo.repository.entities.ProjectVoteEntity;
import com.example.demo.repository.repositories.ProjectVoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProjectVoteService {

    private final ProjectVoteRepository projectVoteRepository;

    public ProjectVoteService(ProjectVoteRepository projectVoteRepository) {
        this.projectVoteRepository = projectVoteRepository;
    }

    public void vote(UUID projectId) {
        ProjectVoteEntity vote = new ProjectVoteEntity(
                UUID.randomUUID(),
                projectId,
                LocalDateTime.now());

        projectVoteRepository.save(vote);
    }

    public Map<UUID, Integer> getVotesForProjects(Collection<UUID> projectIds) {
        return projectVoteRepository.getProjectVoteCountByProjectId(projectIds)
                .stream().collect(Collectors.toMap(ProjectToCount::getProjectId, ProjectToCount::getCount));
    }
}
