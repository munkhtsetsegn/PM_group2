package green.springtest.springtestapp.repositories;

import green.springtest.springtestapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
