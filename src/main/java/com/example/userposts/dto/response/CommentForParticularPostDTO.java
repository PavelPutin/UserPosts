package com.example.userposts.dto.response;

import lombok.Data;

@Data
public class CommentForParticularPostDTO {
    private UserDTO user;
    private String body;
}
