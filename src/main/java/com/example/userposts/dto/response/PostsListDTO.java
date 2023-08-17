package com.example.userposts.dto.response;

import com.example.userposts.model.Post;
import lombok.Data;

import java.util.List;

public record PostsListDTO(List<PostDTO> posts) {
}
