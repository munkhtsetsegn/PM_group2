package test.project.Spring5web.repositories;

import org.springframework.data.repository.CrudRepository;
import test.project.Spring5web.domain.Author;
import test.project.Spring5web.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
