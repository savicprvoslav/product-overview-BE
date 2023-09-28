package com.example.demo.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@Getter
@EqualsAndHashCode
public class Product {
    private UUID id;
    private String name;

    public Product(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

}
