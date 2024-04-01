package com.project.exception;

public class UserExistException extends Exception{
    public UserExistException(String message) {
        super(message);
    }
}
