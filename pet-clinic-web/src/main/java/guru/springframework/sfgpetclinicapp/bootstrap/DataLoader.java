package guru.springframework.sfgpetclinicapp.bootstrap;

import guru.springframework.sfgpetclinicapp.model.*;
import guru.springframework.sfgpetclinicapp.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count==0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat =new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

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

        Visit dogVisit = new Visit();
        dogVisit.setPet(jagsPet);
        dogVisit.setDescription("Visited Bunny on Sunday");
        dogVisit.setDate(LocalDate.now());
        visitService.save(dogVisit);

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
        vet1.getSpecialities().add(savedSurgery);
        vetService.save(vet1);

        Vet vet2= new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedRadiology);
        vetService.save(vet2);
        System.out.println("Vets Loaded");
    }
}
