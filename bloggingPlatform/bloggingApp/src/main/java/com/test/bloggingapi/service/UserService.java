package com.test.bloggingapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bloggingapi.model.User;
import com.test.bloggingapi.repository.UsersRepo;

@Service
public class UserService {

    @Autowired
    UsersRepo urepo;

    public void createUser(User user) {
        urepo.save(user);
    }

    public void deleteUser(Integer id) {
        urepo.deleteById(id);
    }

    public void updateUser(Integer id, User user) {
        User u = urepo.findById(id).get();
        u.setUserName(user.getUserName());
        u.setEmail(user.getEmail());
        urepo.save(u);
    }

}
