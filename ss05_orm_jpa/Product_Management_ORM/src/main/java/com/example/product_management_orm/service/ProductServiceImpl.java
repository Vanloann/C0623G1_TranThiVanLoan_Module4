package com.example.product_management_orm.service;

import com.example.product_management_orm.model.Product;
import com.example.product_management_orm.repository.IProductRepo;

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
    public Product findById(Long id) {
        return productRepo.findById(id);
    }

    @Override
    public void remove(Long id) {
        productRepo.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return productRepo.searchByName(name);
    }
}
