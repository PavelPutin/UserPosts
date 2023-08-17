package com.example.userposts.dto.response;

import lombok.Data;

@Data
public class PostTagDTO {
    private TagDTO tag;
    private String additionalTagName;
}
