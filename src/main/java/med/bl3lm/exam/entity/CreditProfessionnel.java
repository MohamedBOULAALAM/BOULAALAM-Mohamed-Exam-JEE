package med.bl3lm.exam.entity;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CreditProfessionnel extends Credit {
    private String motif;
    private String raisonSociale;
}