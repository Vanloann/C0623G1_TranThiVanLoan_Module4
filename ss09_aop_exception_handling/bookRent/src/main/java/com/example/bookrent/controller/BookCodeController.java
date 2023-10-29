package com.example.bookrent.controller;

import ch.qos.logback.classic.sift.AppenderFactoryUsingJoran;
import com.example.bookrent.config.ExceptionHandler;
import com.example.bookrent.model.Book;
import com.example.bookrent.model.BookCode;
import com.example.bookrent.service.IBookCodeService;
import com.example.bookrent.service.IBookService;
import com.example.bookrent.utils.MyException;
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
        int code = bookCodeService.generateRandomCode();
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
    public String rent(@RequestParam (value = "rentingAmount", required = false) Integer rentingAmount, @ModelAttribute BookCode bookCode,  RedirectAttributes redirectAttributes) throws MyException {
        Book book = bookService.findById(bookCode.getBook().getId());
        if (book.getQuantity() < rentingAmount) {
            throw new MyException("Your renting quantity cannot exceed the remaining quantity of this kind of book!");
        } else {
            book.setQuantity(book.getQuantity()-bookCode.getRentingAmount());
            bookCode.setStatus(1);
            bookCode.setBook(book);
            bookCodeService.create(bookCode);
            redirectAttributes.addFlashAttribute("noti", "Successfully rented book!");
        }
        return "redirect:/";
    }

    @GetMapping("/return")
    public ModelAndView showReturnForm() {
        return new ModelAndView("return");
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam ("bookCode") Integer bookCode, Model model, RedirectAttributes redirectAttributes) {
        BookCode code = bookCodeService.findByCode(bookCode);
        if (code != null && code.getStatus() == 0) {
            redirectAttributes.addFlashAttribute("message", "This book was returned before!");
            return "redirect:/rent/return";
        } else if (code == null) {
            redirectAttributes.addFlashAttribute("message", "Wrong code!");
            return "redirect:/rent/return";
        } else {
            code.setStatus(0);
            System.out.println(code.getRentingAmount());
            Book book = code.getBook();
            System.out.println(book.getQuantity());
            book.setQuantity(book.getQuantity() + code.getRentingAmount());
            bookCodeService.create(code);
        }
        return "redirect:/";
    }

}
