package com.example.product_management_orm.service;

import com.example.product_management_orm.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> showList();

    void create(Product product);

    Product findById(Long id);

    void update(Long id, Product product);

    void remove(Long id);

    List<Product> searchByName(String name);


}
