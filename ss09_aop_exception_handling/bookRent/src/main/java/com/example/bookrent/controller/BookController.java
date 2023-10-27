package com.example.bookrent.controller;

import com.example.bookrent.model.Book;
import com.example.bookrent.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public ModelAndView showList() {
        List<Book> bookList = bookService.showList();
        return new ModelAndView("list", "bookList", bookList);
    }

    @GetMapping("/view/{id}")
    public ModelAndView showInfor(@PathVariable Integer id) {
        return new ModelAndView("view", "book", bookService.findById(id));
    }
}
