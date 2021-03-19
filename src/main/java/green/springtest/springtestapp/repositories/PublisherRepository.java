package green.springtest.springtestapp.repositories;

import green.springtest.springtestapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
