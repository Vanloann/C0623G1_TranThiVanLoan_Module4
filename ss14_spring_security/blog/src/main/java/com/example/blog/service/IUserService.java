package com.example.blog.service;

import com.example.blog.model.User;

public interface IUserService {
    User findByUsername(String name);
}
