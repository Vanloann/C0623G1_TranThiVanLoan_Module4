package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ModelAndView showCategoryList() {
        List<Category> categoryList = categoryService.showList();
        return new ModelAndView("category_list", "categoryList", categoryList);
    }

    @GetMapping("/create")
    public ModelAndView showCatCreateForm() {
        return new ModelAndView("create_category", "category", new Category());
    }

    @PostMapping("/create")
    public String createCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.create(category);
        redirectAttributes.addFlashAttribute("message", "Successfully added new category!");
        return "redirect:/category/";
    }

    @GetMapping("/view/{id}")
    public ModelAndView showBlogByCategoryId(@PathVariable Long id, Model model) {
        List<Blog> blogList = blogService.findBlogByCategoryId(id);
        Optional<Category> categoryOptional = categoryService.findById(id);
        model.addAttribute("blogList", blogList);
        return new ModelAndView("view_by_cate_id", "category", categoryOptional.get());
    }

    @GetMapping("/update/{id}")
    public ModelAndView showCatUpdateForm(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        return new ModelAndView("update_category", "category", category.get());
    }

    @PostMapping("/update/{id}")
    public String updateCategory(@ModelAttribute Category category) {
        categoryService.create(category);
        return "redirect:/category";
    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteCategory(@PathVariable Long id) {
//        categoryService.remove(id);
//        return "redirect:/category";
//    }

}
