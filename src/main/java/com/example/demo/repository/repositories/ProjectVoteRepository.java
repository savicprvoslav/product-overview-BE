package com.example.demo.repository.repositories;

import com.example.demo.repository.projections.ProjectToCount;
import com.example.demo.repository.entities.ProjectVoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.UUID;

public interface ProjectVoteRepository extends JpaRepository<ProjectVoteEntity, UUID> {

    @Query("SELECT new com.example.demo.repository.projections.ProjectToCount(pv.projectId , count(pv.id)) " +
            "FROM ProjectVoteEntity pv " +
            "WHERE pv.projectId IN :projectIds " +
            "GROUP BY pv.projectId")
    Collection<ProjectToCount> getProjectVoteCountByProjectId(Collection<UUID> projectIds);
}

