package guru.springframework.sfgpetclinicapp.services;

import guru.springframework.sfgpetclinicapp.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findByLastName(String lastName);
    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}
