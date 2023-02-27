package expert.os.jakarta.data.nosql;

import jakarta.data.repository.PageableRepository;
import jakarta.data.repository.Repository;

@Repository
public interface PersonRepository extends PageableRepository<Person, Long> {
}
