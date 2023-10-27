package com.example.cart.service;

import com.example.cart.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> showList();

    Optional<Product> findById(int id);
}
