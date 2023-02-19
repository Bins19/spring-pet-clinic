package guru.springframework.springpetclinic.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "specialities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Speciality extends BaseEntity {

    @Column(name = "description")
    private String description;

}
