package guru.springframework.sfgpetclinicapp.repositories;

import guru.springframework.sfgpetclinicapp.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
