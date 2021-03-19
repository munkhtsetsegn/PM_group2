package green.springtest.springtestapp.repositories;

import green.springtest.springtestapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
