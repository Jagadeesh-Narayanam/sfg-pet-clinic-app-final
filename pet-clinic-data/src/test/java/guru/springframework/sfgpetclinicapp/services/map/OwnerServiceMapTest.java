package guru.springframework.sfgpetclinicapp.services.map;

import guru.springframework.sfgpetclinicapp.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {
    OwnerServiceMap ownerServiceMap;
    final Long ownerId=1L;
    final String lastName="Narayanam";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(),new PetServiceMap());
        ownerServiceMap.save(Owner.builder().firstName("Jagadeesh").lastName("Narayanam").build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(1,owners.size());
    }

    @Test
    void findById() {
        Owner owner= ownerServiceMap.findById(ownerId);
        assertEquals(ownerId,owner.getId());
    }

//    @Test
//    void saveExistingId(){
//        Long id=2L;
//        Owner owner2 = Owner.builder().firstName("abbas").lastName("raza").build();
//        Owner savedOwner = ownerServiceMap.save(owner2);
//        assertEquals(id,savedOwner.getId());
//    }
//    @Test
//    void saveNoId() {
//        Owner savedOwner = ownerServiceMap.save(Owner.builder().build());
//        assertNotNull(savedOwner);
//        assertNotNull(savedOwner.getId());
//    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner jagadeesh = ownerServiceMap.findByLastName(lastName);
        assertNotNull(jagadeesh);
        assertEquals(1,jagadeesh.getId());
    }
    @Test
    void findByLastNameNotFound(){
        Owner jagadeesh = ownerServiceMap.findByLastName("foo");
        assertNull(jagadeesh);
    }
}