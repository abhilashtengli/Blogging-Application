package com.test.bloggingapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.bloggingapi.model.Post;

public interface PostRepo extends JpaRepository<Post, Integer> {
    
}
