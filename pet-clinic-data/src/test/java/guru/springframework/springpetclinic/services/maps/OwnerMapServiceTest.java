package guru.springframework.springpetclinic.services.maps;

import guru.springframework.springpetclinic.models.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService service;
    final Long OWNER_ID = 1L;
    final String LAST_NAME = "Smith";

    @BeforeEach
    void setUp() {
        service = new OwnerMapService(new PetMapService(), new PetTypeMapService());
        service.save(Owner.builder().id(OWNER_ID).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = service.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void delete() {
        service.delete(service.findById(OWNER_ID));
        assertEquals(0, service.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner savedOwner = service.save(Owner.builder().id(id).build());
        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner = service.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void deleteById() {
        service.deleteById(OWNER_ID);
        assertEquals(0, service.findAll().size());
    }

    @Test
    void findById() {
        Owner owner = service.findById(OWNER_ID);
        assertEquals(OWNER_ID, owner.getId());
    }

    @Test
    void findByLastName() {
        service.save(Owner.builder().lastName(LAST_NAME).build());
        Owner owner = service.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, owner.getLastName());
    }

    @Test
    void findByLastNameNotFound() {
        Owner owner = service.findByLastName(LAST_NAME);
        assertNull(owner);
    }
}