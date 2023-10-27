package com.example.bookrent.service;

import com.example.bookrent.model.Book;
import com.example.bookrent.repository.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements IBookService{
    @Autowired
    private IBookRepo bookRepo;

    @Override
    public List<Book> showList() {
        return bookRepo.findAll();
    }

    @Override
    public Book findById(int id) {
        return bookRepo.findById(id).get();
    }

}
