package guru.springframework.springpetclinic.services;

import guru.springframework.springpetclinic.models.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
