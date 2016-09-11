package tech.alexin.sbdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tech.alexin.sbdemo.domain.Book;
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

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newBook() {
        return "books/new";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam("title") String title,
                         @RequestParam("description") String description) {
        repository.save(new Book(title, description));
        return new ModelAndView("redirect:/books");
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long id) {
        repository.delete(id);
        return new ModelAndView("redirect:/books");
    }
}
