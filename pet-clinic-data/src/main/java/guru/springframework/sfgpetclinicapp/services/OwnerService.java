package guru.springframework.sfgpetclinicapp.services;

import guru.springframework.sfgpetclinicapp.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner,Long>{
    Owner findByLastName(String lastName);

}
