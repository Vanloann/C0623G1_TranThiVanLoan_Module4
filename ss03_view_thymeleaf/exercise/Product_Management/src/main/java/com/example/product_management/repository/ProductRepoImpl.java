package com.example.product_management.repository;

import com.example.product_management.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepoImpl implements IProductRepo{
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Fridge", 200, "new", "China" ));
        products.put(2, new Product(2, "TV", 500, "new", "Singapore" ));
        products.put(3, new Product(3, "Air-conditioner", 1000, "new", "China" ));
        products.put(4, new Product(4, "Fan", 100, "new", "USA" ));
    }
    @Override
    public List<Product> showList() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void create(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
      List<Product> productList = new ArrayList<>();
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            if (entry.getValue().getName().contains(name)) {
                productList.add(entry.getValue());
            }
        }
        return productList;
    }
}
