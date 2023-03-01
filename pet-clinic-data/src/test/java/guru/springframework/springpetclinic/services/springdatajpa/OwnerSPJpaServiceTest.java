package guru.springframework.springpetclinic.services.springdatajpa;

import guru.springframework.springpetclinic.models.Owner;
import guru.springframework.springpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSPJpaServiceTest {

    @InjectMocks
    OwnerSPJpaService service;
    @Mock
    OwnerRepository ownerRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());
        when(ownerRepository.findAll()).thenReturn(owners);

        assertEquals(2, service.findAll().size());
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertNull(service.findById(1L));
    }

    @Test
    void findById() {
        Owner owner = Owner.builder().id(1L).build();
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.ofNullable(owner));

        assertEquals(1L, service.findById(1L).getId());
    }

    @Test
    void save() {
        Owner owner = Owner.builder().id(1L).build();
        when(ownerRepository.save(any())).thenReturn(owner);

        assertEquals(1L, service.save(owner).getId());
    }

    @Test
    void delete() {
        Owner owner = Owner.builder().id(1L).build();

        service.delete(owner);

        verify(ownerRepository).delete(owner);
    }

    @Test
    void deleteById() {
        Owner owner = Owner.builder().id(1L).build();

        service.deleteById(1L);

        verify(ownerRepository).deleteById(1L);
    }

    @Test
    void findByLastName() {
        String lastName = "Smith";
        Owner owner = Owner.builder().id(1L).lastName(lastName).build();
        when(ownerRepository.findByLastName(anyString())).thenReturn(owner);

        Owner smith = service.findByLastName(lastName);

        assertEquals(lastName, smith.getLastName());
    }
}