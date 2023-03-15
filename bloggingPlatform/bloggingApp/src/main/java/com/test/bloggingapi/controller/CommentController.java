package com.test.bloggingapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.bloggingapi.model.Comments;
import com.test.bloggingapi.service.CommentService;

@RestController
@RequestMapping("/api/v1")
public class CommentController {
    
    @Autowired
    CommentService service;


    @PostMapping("/comment")
    public ResponseEntity<String> addComment(@RequestBody String comment){
        service.saveComment(comment);
         return   new ResponseEntity<>("Comment Saved", HttpStatus.CREATED);
    }

    @GetMapping("/get-all-comments")
    public List<Comments> getAllComments(){
        return service.getAllComments();
    }

    @DeleteMapping("delete-comment/id/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable Integer id){
        service.deleteComment(id);
        return new ResponseEntity<>("Comments deleted", HttpStatus.CREATED);
    }
}
