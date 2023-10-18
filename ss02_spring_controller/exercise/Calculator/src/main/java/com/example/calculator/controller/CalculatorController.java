package com.example.calculator.controller;

import com.example.calculator.service.CalculatorServiceImpl;
import com.example.calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping
    public ModelAndView showForm() {
        return new ModelAndView("index");
    }

    @PostMapping("/calculate")
    public ModelAndView showResult( int firstOperator, int secondOperator, String operator) {
        int result = calculatorService.calculate(firstOperator, secondOperator, operator);
        return new ModelAndView("index", "result", result);
    }
}
