package com.example.customer.management.repository;

import com.example.customer.management.model.Customer;

import java.util.List;

public interface ICustomerRepo {
    List<Customer> showList();

    Customer findById(int id);

    void update(int id, Customer customer);
}
