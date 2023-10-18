package com.example.customer.management.service;

import com.example.customer.management.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> showList();

    Customer findById(int id);

    void update(int id, Customer customer);
}

