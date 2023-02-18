package guru.springframework.springpetclinic.repositories;

import guru.springframework.springpetclinic.models.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
