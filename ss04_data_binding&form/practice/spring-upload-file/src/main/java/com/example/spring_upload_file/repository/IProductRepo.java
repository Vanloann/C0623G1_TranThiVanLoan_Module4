package com.example.spring_upload_file.repository;

import com.example.spring_upload_file.model.Product;

import java.util.List;

public interface IProductRepo {

    List<Product> showList();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);

}
