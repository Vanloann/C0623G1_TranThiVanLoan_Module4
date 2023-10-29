package com.example.bookrent.service;

import com.example.bookrent.model.BookCode;

public interface IBookCodeService {
    void create(BookCode bookCode);

    BookCode findByCode(int code);

    int generateRandomCode();

}
