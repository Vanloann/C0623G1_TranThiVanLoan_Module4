package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> showList();

    void create(Category category);

    Optional<Category> findById(Long id);

    void update(Long id, Category category);

    void remove(Long id);
}
