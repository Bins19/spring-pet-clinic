package guru.springframework.springpetclinic.repositories;

import guru.springframework.springpetclinic.models.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
