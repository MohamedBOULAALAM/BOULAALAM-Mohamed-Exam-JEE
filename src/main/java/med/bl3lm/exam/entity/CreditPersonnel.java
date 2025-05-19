package med.bl3lm.exam.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CreditPersonnel extends Credit {
    private String motif;
}
