package com.example.userposts.controller;

import com.example.userposts.dto.response.PostDTO;
import com.example.userposts.dto.response.PostsListDTO;
import com.example.userposts.model.Post;
import com.example.userposts.service.PostsService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostsController {
    private final PostsService postsService;
    private final ModelMapper modelMapper;

    public PostsController(PostsService postsService, ModelMapper modelMapper) {
        this.postsService = postsService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public PostsListDTO getAll() {
        return new PostsListDTO(postsService.getAll().stream().map(this::convertToPostDTO).toList());
    }

    private PostDTO convertToPostDTO(Post post) {
        return modelMapper.map(post, PostDTO.class);
    }
}
