package com.example.cart.service;

import com.example.cart.model.Product;
import com.example.cart.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    private IProductRepo productRepo;

    @Override
    public List<Product> showList() {
        return productRepo.findAll();
    }

    @Override
    public Optional<Product> findById(int id) {
//        return Optional.of(productRepo.findById(id).orElse(new Product()));
        return productRepo.findById(id);
    }
}
