package com.example.demo.api.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("projects/{projectId}")
public interface ProjectVoteController {
    @PutMapping("/vote")
    void voteForProject(@PathVariable UUID projectId);
}
