package com.example.blog.service;

import com.example.blog.model.User;
import com.example.blog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public User findByUsername(String name) {
        return userRepo.findByUsername(name);
    }
}
