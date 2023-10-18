package com.example.spring_upload_file.repository;

import com.example.spring_upload_file.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepoImpl implements IProductRepo{
    private List<Product> products = new ArrayList<>();

    @Override
    public List<Product> showList() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
//        for (Product product : products) {
//            if (product.getId() == id) {
//                return product;
//            }
//        }
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        int index = products.indexOf(findById(id));
        products.set(index, product);
    }

    @Override
    public void remove(int id) {
        products.remove(findById(id));
    }
}
