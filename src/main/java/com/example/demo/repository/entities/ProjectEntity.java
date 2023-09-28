package com.example.demo.repository.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
public class ProjectEntity {

    @Column(name = "id", columnDefinition = "varchar(36)")
    @Id
    private UUID id;

    @Column(name = "name", columnDefinition = "varchar(255)")
    private String name;

    @Column(name = "description", columnDefinition = "varchar(255)")
    private String description;


    @Column(name = "productId", columnDefinition = "varchar(36)")
    private UUID productId;

    public ProjectEntity(UUID id, String name, String description, UUID productId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.productId = productId;
    }

    public ProjectEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectEntity that = (ProjectEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, productId);
    }
}
