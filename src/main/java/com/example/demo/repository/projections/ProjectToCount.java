package com.example.demo.repository.projections;

import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;

@Getter
public class ProjectToCount implements Serializable {
    public final UUID projectId;

    public final Integer count;

    public ProjectToCount(UUID projectId, Long count) {
        this.projectId = projectId;
        this.count = count.intValue();
    }
}
