package tech.alexin.sbdemo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.alexin.sbdemo.domain.BookCategory;

@Repository
public interface BookCategoryRepository extends CrudRepository<BookCategory, Long> {
}
