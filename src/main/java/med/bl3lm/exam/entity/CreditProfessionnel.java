package med.bl3lm.exam.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CreditProfessionnel extends Credit {
    private String motif;
    private String raisonSociale;
}