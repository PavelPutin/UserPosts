package com.example.userposts.repository;

import com.example.userposts.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Post, Integer> {
}
