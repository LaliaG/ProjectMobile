package com.example.deliveryservice.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException() {
        super("Comment not found");
    }
}
