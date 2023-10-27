package com.example.bookrent.service;

import com.example.bookrent.model.BookCode;
import com.example.bookrent.repository.IBookCodeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookCodeServiceImpl implements IBookCodeService{
    @Autowired
    private IBookCodeRepo bookCodeRepo;

    @Override
    public void create(BookCode bookCode) {
        bookCodeRepo.save(bookCode);
    }

    @Override
    public BookCode findByCode(int code) {
        return bookCodeRepo.findByCode(code);
    }

}
