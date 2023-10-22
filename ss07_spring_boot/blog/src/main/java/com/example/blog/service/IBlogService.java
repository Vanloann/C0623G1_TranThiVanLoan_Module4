package com.example.blog.service;

import com.example.blog.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> showList();

    void create(Blog blog);

    Optional<Blog> findById(Long id);

    void update(Long id, Blog blog);

    void remove(Long id);

//    List<Blog> searchByName(String name);
}
