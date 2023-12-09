package com.m1xs0n.pr.controllers;

import com.m1xs0n.pr.entities.Category;
import com.m1xs0n.pr.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String listCategories(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categories/list";
    }

    @GetMapping("/{id}")
    public String viewCategory(@PathVariable Long id, Model model) {
        model.addAttribute("categories", categoryService.getCategoryById(id));
        return "categories/view";
    }

    @GetMapping("/new")
    public String newCategoryForm(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "categories/new";
    }

    @PostMapping("/new")
    public String createCategory(@ModelAttribute Category category) {
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }
}

