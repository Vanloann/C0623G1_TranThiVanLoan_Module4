package com.example.customer.management.service;

import com.example.customer.management.model.Customer;
import com.example.customer.management.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService{
    @Autowired
    private ICustomerRepo customerRepo;
    @Override
    public List<Customer> showList() {
        return customerRepo.showList();
    }

    @Override
    public Customer findById(int id) {
        return customerRepo.findById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerRepo.update(id, customer);
    }
}
