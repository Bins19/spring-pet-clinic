package guru.springframework.springpetclinic.services;

import guru.springframework.springpetclinic.models.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
    
}