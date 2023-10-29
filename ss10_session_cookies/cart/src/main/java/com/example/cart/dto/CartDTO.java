package com.example.cart.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDTO {
    private Map<ProductDTO, Integer> productMap = new HashMap<>();

    public CartDTO() {
    }

    public CartDTO(Map<ProductDTO, Integer> productMap) {
        this.productMap = productMap;
    }

    public Map<ProductDTO, Integer> getProductMap() {
        return productMap;
    }

    public void addProduct(ProductDTO productDTO) {
        if (productMap.containsKey(productDTO)) {
            Integer amount = productMap.get(productDTO);
            productMap.replace(productDTO, amount + 1);
        } else {
            productMap.put(productDTO, 1);
        }
    }

    public Long getTotal() {
        long total = 0;
        for (Map.Entry<ProductDTO, Integer> entry : productMap.entrySet()) {
           total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }


}
