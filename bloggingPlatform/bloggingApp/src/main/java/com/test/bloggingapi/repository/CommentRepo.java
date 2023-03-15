package com.test.bloggingapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.bloggingapi.model.Comments;

public interface CommentRepo extends JpaRepository<Comments, Integer>{
    
}
