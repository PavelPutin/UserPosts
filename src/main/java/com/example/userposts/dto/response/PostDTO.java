package com.example.userposts.dto.response;

import lombok.Data;

@Data
public class PostDTO {
    private String title;
    private String body;
    private UserDTO author;
}
