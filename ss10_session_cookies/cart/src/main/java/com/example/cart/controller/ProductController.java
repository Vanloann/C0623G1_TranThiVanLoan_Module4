package com.example.cart.controller;

import com.example.cart.dto.CartDTO;
import com.example.cart.dto.ProductDTO;
import com.example.cart.model.Product;
import com.example.cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping
@SessionAttributes("cart")
public class ProductController {
    @ModelAttribute("cart")
    public CartDTO initCard() {
        return new CartDTO();
    }
    @Autowired
    private IProductService productService;

    @GetMapping
    public ModelAndView showList() {
        return new ModelAndView("list", "productList", productService.showList());
    }

    @GetMapping("/view/{id}")
    public ModelAndView showDetail(@PathVariable Integer id) {
        return new ModelAndView("view", "product", productService.findById(id).get());
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Integer id, @ModelAttribute("cart") CartDTO cart) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(product.get(), productDTO);
            cart.addProduct(productDTO);
        }
        return "redirect:/cart";
    }


}
