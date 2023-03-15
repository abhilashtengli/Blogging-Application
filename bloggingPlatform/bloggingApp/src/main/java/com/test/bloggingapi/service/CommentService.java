package com.test.bloggingapi.service;

import java.time.LocalDateTime;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bloggingapi.model.Comments;
import com.test.bloggingapi.repository.CommentRepo;
import com.test.bloggingapi.repository.PostRepo;
import com.test.bloggingapi.repository.UsersRepo;

@Service
public class CommentService {

    @Autowired
    CommentRepo crepo;

    @Autowired
    PostRepo pRepo;

    @Autowired
    UsersRepo uRepo;

    public void saveComment(String comment) {
        Comments newComments = setComments(comment);
        crepo.save(newComments);
    }

    private Comments setComments(String comment) {
        Comments c = new Comments();
        JSONObject obj = new JSONObject(comment);
        c.setMsg(obj.getString("message"));
        c.setCreated(LocalDateTime.now());
        int postId = Integer.parseInt(obj.getString("postId"));
        c.setPostId(pRepo.findById(postId).get());
        int userId = Integer.parseInt(obj.getString("userId"));
        c.setUserId(uRepo.findById(userId).get());
        return c;
    }

    public List<Comments> getAllComments() {
        return crepo.findAll();
    }

    public void deleteComment(Integer id) {
        crepo.deleteById(id);
    }
    
}
