package com.example.deliveryservice.exception;

public class AlreadyExistException extends Exception{
    public AlreadyExistException() {
        super("comment already exist");
    }
}
