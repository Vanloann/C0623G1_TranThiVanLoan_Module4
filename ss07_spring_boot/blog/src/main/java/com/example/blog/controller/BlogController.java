package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

//    @ModelAttribute("categories")
//    public List<Category> showCategories () {
//        return categoryService.showList();
//    }

    @GetMapping
    public ModelAndView showList() {
        List<Blog> blogList = blogService.showList();
        return new ModelAndView("list", "blogList", blogList);
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(Model model) {
        model.addAttribute("categories", categoryService.showList());
        return new ModelAndView("create", "blog", new Blog());
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.create(blog);
        redirectAttributes.addFlashAttribute("blog", "Successfully added new product!");
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public ModelAndView showDetail(@PathVariable Long id) {
        return new ModelAndView("view", "blog", blogService.findById(id));
    }

    @GetMapping("/update/{id}")
    public ModelAndView showUpdateForm(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        return new ModelAndView("update", "blog", blog.get());
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute Blog blog) {
        blogService.create(blog);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        blogService.remove(id);
        return "redirect:/";
    }

//    @GetMapping("/search_by_name")
//    public ModelAndView search(@RequestParam("searchByName") String searchByName) {
//        List<Product> productList = productService.searchByName(searchByName);
//        return new ModelAndView("list", "productList", productList);
//    }

}
