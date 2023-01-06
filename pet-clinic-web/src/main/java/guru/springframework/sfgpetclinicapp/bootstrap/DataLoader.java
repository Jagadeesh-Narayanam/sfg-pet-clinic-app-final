package guru.springframework.sfgpetclinicapp.bootstrap;

import guru.springframework.sfgpetclinicapp.model.Owner;
import guru.springframework.sfgpetclinicapp.model.PetType;
import guru.springframework.sfgpetclinicapp.model.Vet;
import guru.springframework.sfgpetclinicapp.services.OwnerService;
import guru.springframework.sfgpetclinicapp.services.PetTypeService;
import guru.springframework.sfgpetclinicapp.services.VetService;
import guru.springframework.sfgpetclinicapp.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinicapp.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat =new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1=new Owner();
        owner1.setFirstName("Jagadeesh");
        owner1.setLastName("Narayanam");
        ownerService.save(owner1);

        Owner owner2=new Owner();
        owner2.setFirstName("Abbas");
        owner2.setLastName("Raza");
        ownerService.save(owner2);
        System.out.println("Owners Loaded");

        Vet vet1= new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2= new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vetService.save(vet2);
        System.out.println("Vets Loaded");

    }
}
