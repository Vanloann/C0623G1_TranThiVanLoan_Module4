package com.example.bookrent.service;

import com.example.bookrent.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> showList();

    Book findById(int id);

//    void update(int id, int code);

}
