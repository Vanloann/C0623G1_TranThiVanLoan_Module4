package com.example.customer.management.repository;

import com.example.customer.management.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepoImpl implements ICustomerRepo{
    private static List<Customer> customerList;

    static {
        customerList = new ArrayList<>();
        customerList.add(new Customer(1, "Nguyen Khac Nhat", "nhat@codegym.vn", "Hà Nội"));
        customerList.add(new Customer(2, "Dang Huy Hoa", "hoa.dang@codegym.vn", "Đà nẵng"));
        customerList.add(new Customer(3, "Le Thi Chau", "chau.le@codegym.vn", "Hà Nội"));
        customerList.add(new Customer(4, "Nguyen Thuy Duong", "duong.nguyen@codegym.vn", "Sài Gòn"));
        customerList.add(new Customer(5, "CodeGym", "codegym@codegym.vn", "Việt Nam"));
    }
    @Override
    public List<Customer> showList() {
        return customerList;
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        for (Customer cus: customerList) {
            if (id == cus.getId()) {
                String name = cus.getName();
                String email = cus.getEmail();
                String address = cus.getAddress();
                customer = new Customer(id, name, email, address);
            }
        }
        return customer;
    }

    @Override
    public void update(int id, Customer customer) {
        int index;
        for (Customer cus: customerList) {
            if (id == cus.getId()) {
                index = customerList.indexOf(cus);
                customerList.set(index,customer);
            }
        }

    }
}
