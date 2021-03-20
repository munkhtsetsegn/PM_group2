package test.project.Spring5web.repositories;

import org.springframework.data.repository.CrudRepository;
import test.project.Spring5web.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
