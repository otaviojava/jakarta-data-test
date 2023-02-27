package expert.os.jakarta.data.nosql;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

@Repository
public interface Library extends CrudRepository<String, Book> {
}
