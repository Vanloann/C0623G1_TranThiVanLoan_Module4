package com.example.dictionary.controller;

import com.example.dictionary.service.IDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping()
public class DicController {

    @Autowired
    private IDicService dicService;

    @GetMapping()
    public ModelAndView showForm () {
        return new ModelAndView("index");
    }

    @GetMapping("/dic")
    public ModelAndView translate (@RequestParam String word) {
        return new ModelAndView("index", "word", dicService.translate(word));
    }
}
