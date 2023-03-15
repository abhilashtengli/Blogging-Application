package com.test.bloggingapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.bloggingapi.model.User;
import com.test.bloggingapi.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/users")
    public ResponseEntity<String> createUser( @Valid @RequestBody User user) {
        service.createUser(user);
        return new ResponseEntity<>("user Saved", HttpStatus.CREATED);
    }

    @PutMapping("/update-user/id/{id}")
    public ResponseEntity<String> updatePost(@PathVariable Integer id, @Valid @RequestBody User user){
        service.updateUser(id, user);
        return new ResponseEntity<>("User updated", HttpStatus.CREATED);
    }

    @DeleteMapping("delete-user/id/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id){
        service.deleteUser(id);
        return new ResponseEntity<>("User deleted", HttpStatus.CREATED);
    }

    
}
