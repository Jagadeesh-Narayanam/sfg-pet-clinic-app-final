package guru.springframework.sfgpetclinicapp.repositories;

import guru.springframework.sfgpetclinicapp.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality,Long> {
}
