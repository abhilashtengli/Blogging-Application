package com.test.bloggingapi.service;

import java.time.LocalDateTime;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bloggingapi.model.Post;
import com.test.bloggingapi.repository.PostRepo;
import com.test.bloggingapi.repository.UsersRepo;

@Service
public class PostService {

    @Autowired
    PostRepo prepo;

    @Autowired
    UsersRepo uRepo;

    public void savePost(String post) {
        Post p = setPost(post);
        prepo.save(p);
    }

    private Post setPost(String post) {
        JSONObject obj = new JSONObject(post);
        Post p1 = new Post();
        p1.setContent(obj.getString("content"));
        p1.setCreated(LocalDateTime.now());
        int id = Integer.parseInt(obj.getString("userId"));
        p1.setUserId(uRepo.findById(id).get());
        return p1;
    }

    public List<Post> getPost() {
        return prepo.findAll();
    }

    public void deletePost(Integer id) {
        prepo.deleteById(id);
    }

    public void updatePost(Integer id, String post) {
        Post p = prepo.findById(id).get();
        Post update = setPost(post);
        p.setUserId(update.getUserId());
        p.setContent(update.getContent());
        p.setCreated(LocalDateTime.now());
        prepo.save(p);
    }

}
