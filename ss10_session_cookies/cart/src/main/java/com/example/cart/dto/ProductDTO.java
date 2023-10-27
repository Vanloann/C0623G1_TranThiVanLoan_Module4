package com.example.cart.dto;

import javax.persistence.Column;
import java.util.Objects;

public class ProductDTO {
    private int id;
    private String name;
    private String image;
    private String description;
    private Long price;

    public ProductDTO() {
    }

    public ProductDTO(int id, String name, String image, String description, Long price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ProductDTO productDTO = (ProductDTO) obj;
        return id == productDTO.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
