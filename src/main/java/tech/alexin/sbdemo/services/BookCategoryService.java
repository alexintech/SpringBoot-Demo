package tech.alexin.sbdemo.services;

import tech.alexin.sbdemo.domain.BookCategory;

public interface BookCategoryService {

    Iterable<BookCategory> listAllCategories();

    BookCategory getCategoryById(Long id);

    BookCategory saveCategory(BookCategory bookCategory);

    void deleteCategory(Long id);
}
