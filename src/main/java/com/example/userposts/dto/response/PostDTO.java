package com.example.userposts.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class PostDTO {
    private String title;
    private String body;
    private UserDTO author;
    private int likesNumber;
    private List<CommentForParticularPostDTO> comments;
}
