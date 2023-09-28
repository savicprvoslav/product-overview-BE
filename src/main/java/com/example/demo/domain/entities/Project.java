package com.example.demo.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    private UUID id;

    private String name;

    private String description;

    private Integer voteCount;

    private UUID productId;
}
