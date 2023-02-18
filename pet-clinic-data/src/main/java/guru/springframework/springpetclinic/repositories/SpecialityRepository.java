package guru.springframework.springpetclinic.repositories;

import guru.springframework.springpetclinic.models.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
