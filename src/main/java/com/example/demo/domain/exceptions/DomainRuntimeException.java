package com.example.demo.domain.exceptions;

public class DomainRuntimeException extends RuntimeException {
    public DomainRuntimeException(String message) {
        super(message);
    }
}
