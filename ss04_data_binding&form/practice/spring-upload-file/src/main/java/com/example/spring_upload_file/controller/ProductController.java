package com.example.spring_upload_file.controller;

import com.example.spring_upload_file.model.Product;
import com.example.spring_upload_file.model.ProductForm;
import com.example.spring_upload_file.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping
    private ModelAndView showList() {
        List<Product> products = productService.showList();
        return new ModelAndView("index", "products", products);
    }

    @GetMapping("/create")
    private ModelAndView showCreateForm() {
        return new ModelAndView("create", "productForm", new ProductForm());
    }

    @Value("${file-upload}")
    private String fileUpload;

    @PostMapping("/save")
    private ModelAndView saveProduct(@ModelAttribute ProductForm productForm) {
        MultipartFile multipartFile = productForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(productForm.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Product product = new Product(productForm.getId(), productForm.getName(), productForm.getDescription(), fileName);
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product", product);
        modelAndView.addObject("message", "Created new product successfully");
        return modelAndView;
    }
}
