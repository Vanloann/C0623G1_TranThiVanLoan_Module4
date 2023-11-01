package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepo extends JpaRepository<Blog, Long> {
    Page<Blog> findByTitleContaining(String name, Pageable pageable);

    @Query(nativeQuery = true, value = "select * from blog where category_id =:param")
    List<Blog> findBlogByCategoryId(@Param("param") Long id);
}
