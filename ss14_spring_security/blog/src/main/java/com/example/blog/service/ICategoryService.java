package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> showList();

    Page<Category> showList(Pageable pageable);

    void create(Category category);

    Optional<Category> findById(Long id);

    void update(Long id, Category category);

    void remove(Long id);




}
