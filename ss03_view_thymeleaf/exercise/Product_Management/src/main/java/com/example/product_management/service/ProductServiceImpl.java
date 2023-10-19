package com.example.product_management.service;

import com.example.product_management.model.Product;
import com.example.product_management.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    private IProductRepo productRepo;

    @Override
    public List<Product> showList() {
        return productRepo.showList();
    }

    @Override
    public void create(Product product) {
        productRepo.create(product);
    }

    @Override
    public Product findById(int id) {
        return productRepo.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        productRepo.update(id, product);
    }

    @Override
    public void remove(int id) {
        productRepo.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return productRepo.searchByName(name);
    }
}
