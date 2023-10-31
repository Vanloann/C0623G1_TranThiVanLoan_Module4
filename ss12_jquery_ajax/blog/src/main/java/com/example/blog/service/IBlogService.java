package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> showList();

    List<Blog> paginate(int num);

    Page<Blog> showList(Pageable pageable);

    void create(Blog blog);

    Optional<Blog> findById(Long id);

    void update(Long id, Blog blog);

    void remove(Long id);

    List<Blog> searchByName(String name);

    List<Blog> findBlogByCategoryId(Long id);
}
