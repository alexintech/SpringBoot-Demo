package tech.alexin.sbdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tech.alexin.sbdemo.repositories.BookRepository;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository repository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String listBooks(Model model) {
        model.addAttribute("books", repository.findAll());
        return "books/list";
    }
}
