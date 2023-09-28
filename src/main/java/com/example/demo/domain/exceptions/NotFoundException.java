package com.example.demo.domain.exceptions;

public class NotFoundException extends DomainRuntimeException {
    public NotFoundException(String message) {
        super("Object not found: " + message + ".");
    }
}
