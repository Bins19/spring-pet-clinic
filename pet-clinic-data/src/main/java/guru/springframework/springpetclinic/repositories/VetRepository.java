package guru.springframework.springpetclinic.repositories;

import guru.springframework.springpetclinic.models.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
