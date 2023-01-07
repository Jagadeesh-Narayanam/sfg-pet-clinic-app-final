package guru.springframework.sfgpetclinicapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="specialities")
public class Speciality extends BaseEntity{

    @Column(name="description")
    private String description;

}
