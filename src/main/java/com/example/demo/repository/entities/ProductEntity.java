package com.example.demo.repository.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
public class ProductEntity {
    @Column(name = "id", columnDefinition = "varchar(36)")
    @Id
    private UUID id;
    @Column(name = "name", columnDefinition = "varchar(255)")
    private String name;

    public ProductEntity(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
