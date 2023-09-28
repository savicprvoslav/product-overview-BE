package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IDGenerator {

    public UUID generateID() {
        return UUID.randomUUID();
    }
}
