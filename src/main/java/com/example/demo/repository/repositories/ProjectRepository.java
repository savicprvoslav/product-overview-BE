package com.example.demo.repository.repositories;

import com.example.demo.repository.entities.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, UUID> {
    Collection<ProjectEntity> findProjectByProductId(UUID productId);
}
