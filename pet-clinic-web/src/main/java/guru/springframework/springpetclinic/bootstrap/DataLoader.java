package guru.springframework.springpetclinic.bootstrap;

import guru.springframework.springpetclinic.models.Owner;
import guru.springframework.springpetclinic.models.Vet;
import guru.springframework.springpetclinic.services.OwnerService;
import guru.springframework.springpetclinic.services.VetService;
import guru.springframework.springpetclinic.services.maps.OwnerServiceMap;
import guru.springframework.springpetclinic.services.maps.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;

    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Fiona");
        owner1.setLastName("Glenanne");
        ownerService.save(owner2);

        System.out.println("Loaded owners ......");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Jessie");
        vet1.setLastName("Porter");
        vetService.save(vet2);
        System.out.println("Loaded vets .......");
    }

}
