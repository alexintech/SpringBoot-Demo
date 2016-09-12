package tech.alexin.sbdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tech.alexin.sbdemo.domain.Book;
import tech.alexin.sbdemo.services.BookService;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "")
    public String list(Model model) {
        model.addAttribute("books", bookService.listAllBooks());
        return "books/list";
    }

    @GetMapping(value = "/{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "books/show";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "books/form";
    }

    @GetMapping(value = "/new")
    public String create(Model model) {
        model.addAttribute("book", new Book());
        return "books/form";
    }

    @PostMapping(value = "")
    public String save(@Valid @ModelAttribute("book") Book book,
                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/form";
        }
        bookService.saveBook(book);
        return "redirect:/books/" + book.getId();
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
