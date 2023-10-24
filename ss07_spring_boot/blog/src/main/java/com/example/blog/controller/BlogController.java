package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public ModelAndView showList(@PageableDefault (value = 4) Pageable pageable) {
        return new ModelAndView("list", "blogList", blogService.showList(pageable));
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
    public ModelAndView showDetail(@PathVariable Long id, Model model) {
        return new ModelAndView("view", "blog", blogService.findById(id).get());
    }

    @GetMapping("/update/{id}")
    public ModelAndView showUpdateForm(@PathVariable Long id, Model model) {
        model.addAttribute("categories", categoryService.showList());
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

    @GetMapping("/search_by_name")
    public ModelAndView search(@RequestParam("searchByName") String searchByName,@PageableDefault (value = 4) Pageable pageable) {
        Page<Blog> blogList = blogService.searchByName(searchByName, pageable);
        return new ModelAndView("list", "blogList", blogList);
//        return "redirect:/";
    }

}
