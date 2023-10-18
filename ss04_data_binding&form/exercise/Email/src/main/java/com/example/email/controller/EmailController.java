package com.example.email.controller;

import com.example.email.model.Email;
import com.example.email.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class EmailController {

    @Autowired
    private IEmailService emailService;

    @GetMapping
    public ModelAndView showEmailForm(Model model) {
        List<String> languagesList = new ArrayList<>();
        languagesList.add("English");
        languagesList.add("Vietnamese");
        languagesList.add("Japanese");
        languagesList.add("Chinese");

        List<Integer> pages = new ArrayList<>();
        pages.add(5);
        pages.add(10);
        pages.add(15);
        pages.add(25);
        pages.add(50);
        pages.add(100);

        model.addAttribute("languagesList", languagesList);
        model.addAttribute("pages", pages);
        model.addAttribute("email", new Email());
        return new ModelAndView("index");
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Email email, RedirectAttributes attributes) {
        emailService.update(email.getId(), email);
        attributes.addFlashAttribute("emails",emailService.findById(email.getId()));
        return "redirect:update";
    }

    @GetMapping("/update")
    public ModelAndView showUpdate() {
        return new ModelAndView("update");
    }
}
