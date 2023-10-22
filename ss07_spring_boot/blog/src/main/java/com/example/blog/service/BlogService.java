package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepo blogRepo;

    @Override
    public List<Blog> showList() {
        return blogRepo.findAll();
    }

    @Override
    public void create(Blog blog) {
        blogRepo.save(blog);
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return Optional.ofNullable(blogRepo.findById(id).orElse(null));
    }

    @Override
    public void update(Long id, Blog blog) {
        blogRepo.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepo.deleteById(id);
    }
}
