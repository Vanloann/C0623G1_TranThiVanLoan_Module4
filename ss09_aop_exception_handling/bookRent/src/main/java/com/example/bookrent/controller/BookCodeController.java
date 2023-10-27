package com.example.bookrent.controller;

import ch.qos.logback.classic.sift.AppenderFactoryUsingJoran;
import com.example.bookrent.model.Book;
import com.example.bookrent.model.BookCode;
import com.example.bookrent.service.IBookCodeService;
import com.example.bookrent.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.criteria.CriteriaBuilder;

@Controller
@RequestMapping("/rent")
public class BookCodeController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBookCodeService bookCodeService;

    @GetMapping("/create/{id}")
    public ModelAndView showRentingInf(@PathVariable Integer id, Model model) {
        int code = (int) (Math.random() * 20001) + 10000;
        model.addAttribute("codeRandom",code);
        model.addAttribute("bookTitle", bookService.findById(id));
        BookCode bookCode = new BookCode();
        bookCode.setCode(code);
        Book book = new Book();
        book.setId(id);
        bookCode.setBook(book);
        return new ModelAndView("rentInfor", "bookCode", bookCode);
    }

    @PostMapping("/create")
    public String rent(@ModelAttribute BookCode bookCode, RedirectAttributes redirectAttributes) throws Exception {
        Book book = bookService.findById(bookCode.getBook().getId());
        if (book.getQuantity() == 0) {
            throw new Exception("This kind of book has been rented out!");
        } else {
            book.setQuantity(book.getQuantity()-bookCode.getRentingAmount());
            bookCode.setBook(book);
            bookCodeService.create(bookCode);
            return "redirect:/";
        }
    }

    @GetMapping("/return")
    public ModelAndView showReturnForm() {
        return new ModelAndView("return");
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam ("bookCode") Integer bookCode) {
        BookCode code = bookCodeService.findByCode(bookCode);
        System.out.println(code.getRentingAmount());
        Book book = code.getBook();
        System.out.println(book.getQuantity());
        book.setQuantity(book.getQuantity() + code.getRentingAmount());
        bookCodeService.create(code);
        return "redirect:/";
    }

}
