package guru.springframework.sfgpetclinicapp.repositories;

import guru.springframework.sfgpetclinicapp.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
}
