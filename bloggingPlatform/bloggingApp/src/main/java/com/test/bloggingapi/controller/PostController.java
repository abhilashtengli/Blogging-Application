package com.test.bloggingapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.bloggingapi.model.Post;
import com.test.bloggingapi.service.PostService;



@RestController
@RequestMapping("/api/v1")
public class PostController {
    
    @Autowired
    PostService service;

    @PostMapping("/add-post")
    public ResponseEntity<String> addPosts( @RequestBody String post) {
        service.savePost(post);
        return new ResponseEntity<>("Post Saved", HttpStatus.CREATED);
    }

    @GetMapping("/get-all-posts")
    public List<Post> getAllPost(){
        return service.getPost();
    }

    @DeleteMapping("delete-post/id/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Integer id){
        service.deletePost(id);
        return new ResponseEntity<>("Post deleted", HttpStatus.CREATED);
    }
    @PutMapping("/update-post/id/{id}")
    public ResponseEntity<String> updatePost(@PathVariable Integer id, @RequestBody String post){
        service.updatePost(id, post);
        return new ResponseEntity<>("Post updated", HttpStatus.CREATED);
    }

    
}
