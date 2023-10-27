package com.example.bookrent.model;

import org.aspectj.apache.bcel.classfile.Code;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String image;
    private String brief;
    private String author;
    private int quantity;

    @OneToMany (mappedBy = "book", cascade = CascadeType.ALL)
    private Set<BookCode> codes;

    public Book() {
    }

    public Book(int id, String name, String image, String brief, String author, int quantity) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.brief = brief;
        this.author = author;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<BookCode> getCodes() {
        return codes;
    }

    public void setCodes(Set<BookCode> codes) {
        this.codes = codes;
    }
}
