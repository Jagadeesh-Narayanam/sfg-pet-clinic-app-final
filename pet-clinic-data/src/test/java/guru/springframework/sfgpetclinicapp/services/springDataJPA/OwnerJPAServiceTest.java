package guru.springframework.sfgpetclinicapp.services.springDataJPA;

import guru.springframework.sfgpetclinicapp.model.Owner;
import guru.springframework.sfgpetclinicapp.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;
@ExtendWith(MockitoExtension.class)
class OwnerJPAServiceTest {
    @Mock
    OwnerRepository ownerRepository;
    @InjectMocks
    OwnerJPAService ownerJPAService;


    @BeforeEach
    void setUp() {
    }

    @Test
    void findAll() {
        Set<Owner> jagadeesh = ownerJPAService.findAll();
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findByLastName() {
    }
}