package tech.alexin.sbdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tech.alexin.sbdemo.domain.BookCategory;
import tech.alexin.sbdemo.services.BookCategoryService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/category")
public class BookCategoryController {

    private BookCategoryService bookCategoryService;

    @Autowired
    public void setBookCategoryService(BookCategoryService bookCategoryService) {
        this.bookCategoryService = bookCategoryService;
    }

    @GetMapping(value = "")
    public String list(Model model) {
        model.addAttribute("categories", bookCategoryService.listAllCategories());
        return "categories/list";
    }

    @GetMapping(value = "/{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("category", bookCategoryService.getCategoryById(id));
        return "categories/show";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("category", bookCategoryService.getCategoryById(id));
        return "categories/form";
    }

    @GetMapping(value = "/new")
    public String create(Model model) {
        model.addAttribute("category", new BookCategory());
        return "categories/form";
    }

    @PostMapping(value = "")
    public String save(@Valid @ModelAttribute("category") BookCategory bookCategory,
                       BindingResult bindingResult,
                       Model model) {
        if (bindingResult.hasErrors()) {
            return "categories/form";
        }
        bookCategoryService.saveCategory(bookCategory);
        return "redirect:/category/" + bookCategory.getId();
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id) {
        bookCategoryService.deleteCategory(id);
        return "redirect:/category";
    }
}
