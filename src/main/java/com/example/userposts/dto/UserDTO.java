package com.example.userposts.dto;

import org.hibernate.validator.constraints.UUID;

public class UserDTO {
    @UUID(message = "User id should be in UUID format.")
    private String id;
    private String imageUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
