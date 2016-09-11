package tech.alexin.sbdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.alexin.sbdemo.domain.Book;
import tech.alexin.sbdemo.repositories.BookRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    BookRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 5; i++) {
            repository.save(new Book("Title #" + (i + 1)));
        }
    }
}
