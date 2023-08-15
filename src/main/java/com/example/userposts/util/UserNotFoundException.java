package com.example.userposts.util;

public class UserNotFoundException extends RuntimeException {
    private String userId;

    public UserNotFoundException(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
