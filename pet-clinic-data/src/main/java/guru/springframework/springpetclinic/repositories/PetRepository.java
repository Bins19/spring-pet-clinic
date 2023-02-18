package guru.springframework.springpetclinic.repositories;

import guru.springframework.springpetclinic.models.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
