package com.example.demo.repository.repositories;

import com.example.demo.repository.entities.ProductEntity;
import com.example.demo.repository.entities.ProjectEntity;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProjectRepositoryTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    void should_store_project() {
        projectRepository.save(new ProjectEntity(UUID.randomUUID(), "Project 1", "Project 1",UUID.randomUUID()));

        assertEquals(1, projectRepository.findAll().size());
    }
}
