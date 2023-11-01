package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.repository.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepo categoryRepo;

    @Override
    public List<Category> showList() {
        return categoryRepo.findAll();
    }

    public Page<Category> showList(Pageable pageable) {
        return categoryRepo.findAll(pageable);
    }

    @Override
    public void create(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepo.findById(id);
    }

    @Override
    public void update(Long id, Category category) {
        categoryRepo.save(category);
    }


    @Override
    public void remove(Long id) {
        categoryRepo.deleteById(id);
    }


}
