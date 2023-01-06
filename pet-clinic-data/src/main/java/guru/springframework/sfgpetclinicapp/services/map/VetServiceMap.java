package guru.springframework.sfgpetclinicapp.services.map;

import guru.springframework.sfgpetclinicapp.model.Vet;
import guru.springframework.sfgpetclinicapp.services.SpecialityService;
import guru.springframework.sfgpetclinicapp.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"default","map"})
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {
    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if(object!=null){
            if(object.getSpecialities().size()>0){
                object.getSpecialities().forEach(speciality -> {
                    if(speciality.getId()==null){
                        speciality.setId(specialityService.save(speciality).getId());
                    }
                });
            }
            else{
                throw new RuntimeException("Specialities Needed");
            }
            return super.save(object);
        }
        else{
            return null;
        }

    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }
}
