package com.example.blog.repository;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepo extends JpaRepository<Category, Long> {
}
