package com.example.userposts.service;

import com.example.userposts.model.Post;
import com.example.userposts.repository.PostsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsService {
    private final PostsRepository postsRepository;

    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public List<Post> getAll() {
        return postsRepository.findAll();
    }
}
