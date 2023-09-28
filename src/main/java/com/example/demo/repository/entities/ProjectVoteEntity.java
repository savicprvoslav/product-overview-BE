package com.example.demo.repository.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
public class ProjectVoteEntity {

    @Column(name = "id", columnDefinition = "varchar(36)")
    @Id
    private UUID id;

    @Column(name = "projectId", columnDefinition = "varchar(36)")
    private UUID projectId;

    @Column(name = "voteDate", columnDefinition = "timestamp")
    private LocalDateTime voteDate;

    public ProjectVoteEntity() {
    }

    public ProjectVoteEntity(UUID id, UUID projectId, LocalDateTime voteDate) {
        this.id = id;
        this.projectId = projectId;
        this.voteDate = voteDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectVoteEntity that = (ProjectVoteEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(projectId, that.projectId) && Objects.equals(voteDate, that.voteDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectId, voteDate);
    }
}
