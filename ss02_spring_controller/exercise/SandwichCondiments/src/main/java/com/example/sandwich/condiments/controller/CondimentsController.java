package com.example.sandwich.condiments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping()
public class CondimentsController {


    @GetMapping()
    public ModelAndView showCondiments(@RequestParam(value = "condiment", required = false) String[] condiment) {
        return new ModelAndView("index", "condiment", condiment);
    }




}
