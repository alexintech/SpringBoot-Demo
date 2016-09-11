package tech.alexin.sbdemo.repositories;

import org.springframework.data.repository.CrudRepository;
import tech.alexin.sbdemo.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
