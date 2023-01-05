package guru.springframework.sfgpetclinicapp.services;

import guru.springframework.sfgpetclinicapp.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
