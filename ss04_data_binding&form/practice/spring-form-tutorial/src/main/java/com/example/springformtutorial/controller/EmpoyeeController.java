package com.example.springformtutorial.controller;

import com.example.springformtutorial.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class EmpoyeeController {

    @GetMapping
    public ModelAndView showForm () {
        return new ModelAndView("index", "employee", new Employee());
    }

    @PostMapping("/addEmployee")
    public ModelAndView create(@ModelAttribute ("employee") Employee employee) {
        return new ModelAndView("detail", "employee", employee);
    }
}
