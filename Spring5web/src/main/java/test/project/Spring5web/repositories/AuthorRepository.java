package test.project.Spring5web.repositories;

import org.springframework.data.repository.CrudRepository;
import test.project.Spring5web.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
