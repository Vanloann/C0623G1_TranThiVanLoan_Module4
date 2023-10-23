package com.example.product_management_orm.repository;


import com.example.product_management_orm.model.Product;

import java.util.List;

public interface IProductRepo {

    List<Product> showList();

    void create(Product product);

    Product findById(Long id);

    void remove(Long id);

    List<Product> searchByName(String name);


}
