package tech.alexin.sbdemo.services;

import tech.alexin.sbdemo.domain.Book;

public interface BookService {

    Iterable<Book> listAllBooks();

    Book getBookById(Long id);

    Book saveBook(Book book);

    void deleteBook(Long id);
}
