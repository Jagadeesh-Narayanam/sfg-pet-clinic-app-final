package guru.springframework.sfgpetclinicapp.bootstrap;

import guru.springframework.sfgpetclinicapp.model.Owner;
import guru.springframework.sfgpetclinicapp.model.Pet;
import guru.springframework.sfgpetclinicapp.model.PetType;
import guru.springframework.sfgpetclinicapp.model.Vet;
import guru.springframework.sfgpetclinicapp.services.OwnerService;
import guru.springframework.sfgpetclinicapp.services.PetTypeService;
import guru.springframework.sfgpetclinicapp.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        owner1.setAddress("Main road");
        owner1.setCity("Kaldhari");
        owner1.setTelephone("7989845106");

        Pet jagsPet = new Pet();
        jagsPet.setName("Bunny");
        jagsPet.setPetType(savedDogPetType);
        jagsPet.setOwner(owner1);
        jagsPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(jagsPet);
        ownerService.save(owner1);

        Owner owner2=new Owner();
        owner2.setFirstName("Abbas");
        owner2.setLastName("Raza");
        owner2.setAddress("New Street");
        owner2.setCity("Vijayawada");
        owner2.setTelephone("6281837927");

        Pet razasPet = new Pet();
        razasPet.setName("Tom");
        razasPet.setOwner(owner2);
        razasPet.setPetType(savedCatType);
        razasPet.setBirthDate(LocalDate.now());
        owner2.getPets().add(razasPet);

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
