package com.example.blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String image;
    private String author;
    private String date;

    @JsonBackReference
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "categoryId")
    private Category category;

    public Blog() {
    }

    public Blog(Long id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Blog(Long id, String title, String content, String image, String author, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
        this.author = author;
        this.category = category;
    }

    public Blog(Long id, String title, String content, String image, String author, String date, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
        this.author = author;
        this.date = date;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
