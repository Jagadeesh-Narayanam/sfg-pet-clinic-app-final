package guru.springframework.sfgpetclinicapp.repositories;

import guru.springframework.sfgpetclinicapp.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
