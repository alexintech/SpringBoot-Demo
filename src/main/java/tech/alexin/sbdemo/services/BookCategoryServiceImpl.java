package tech.alexin.sbdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.alexin.sbdemo.domain.BookCategory;
import tech.alexin.sbdemo.repositories.BookCategoryRepository;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {

    private BookCategoryRepository bookCategoryRepository;

    @Autowired
    public void setBookCategoryRepository(BookCategoryRepository bookCategoryRepository) {
        this.bookCategoryRepository = bookCategoryRepository;
    }

    @Override
    public Iterable<BookCategory> listAllCategories() {
        return bookCategoryRepository.findAll();
    }

    @Override
    public BookCategory getCategoryById(Long id) {
        return bookCategoryRepository.findOne(id);
    }

    @Override
    public BookCategory saveCategory(BookCategory bookCategory) {
        return bookCategoryRepository.save(bookCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        bookCategoryRepository.delete(id);
    }
}
