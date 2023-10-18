package com.example.customer.management.controller;

import com.example.customer.management.model.Customer;
import com.example.customer.management.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    @GetMapping()
    public ModelAndView showList() {
        return new ModelAndView("index", "customerList", customerService.showList());
    }

    @GetMapping("/detail/{id}")
    public ModelAndView findById(@PathVariable Integer id) {
        return new ModelAndView("infor", "customer", customerService.findById(id));
    }

    @PostMapping()
    public ModelAndView updateCustomer(@RequestParam Integer id, String name, String email, String address, Model model) {
        Customer customer = new Customer(id, name, email, address);
        customerService.update(id, customer);
        return new ModelAndView("index", "customerList", customerService.showList());
    }
}
