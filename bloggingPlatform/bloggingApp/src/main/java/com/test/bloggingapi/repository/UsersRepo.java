package com.test.bloggingapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.bloggingapi.model.User;

public interface UsersRepo extends JpaRepository<User,Integer> {
    
}
