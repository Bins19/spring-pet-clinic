package guru.springframework.springpetclinic.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetType extends BaseEntity {

    @Column(name = "name")
    private String name;

}
