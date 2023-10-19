package com.example.product_management.repository;

import com.example.product_management.model.Product;

import java.util.List;

public interface IProductRepo {

    List<Product> showList();

    void create(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);

    List<Product> searchByName(String name);


}
