package guru.springframework.sfgpetclinicapp.repositories;

import guru.springframework.sfgpetclinicapp.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
