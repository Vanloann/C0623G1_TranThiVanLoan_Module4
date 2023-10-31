package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
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
    public List<Blog> paginate(int num) {
        return blogRepo.paginate(num);
    }

    @Override
    public Page<Blog> showList(Pageable pageable) {
        return blogRepo.findAll(pageable);
    }

    @Override
    public void create(Blog blog) {
        blogRepo.save(blog);
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepo.findById(id);
    }

    @Override
    public void update(Long id, Blog blog) {
        blogRepo.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepo.deleteById(id);
    }

    @Override
    public List<Blog> searchByName(String name) {
        return blogRepo.findByTitleContaining(name);
    }


    @Override
    public List<Blog> findBlogByCategoryId(Long id) {
        return blogRepo.findBlogByCategoryId(id);
    }


}
