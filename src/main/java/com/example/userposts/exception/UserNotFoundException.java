package com.example.userposts.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends AppException {
    private String userId;

    public UserNotFoundException(String userId) {
        super("User with id " + userId + " not found", HttpStatus.NOT_FOUND);
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
