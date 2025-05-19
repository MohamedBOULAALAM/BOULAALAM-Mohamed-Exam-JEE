package med.bl3lm.exam.entity;

import jakarta.persistence.*;
import lombok.*;
import med.bl3lm.exam.enums.TypeBienImmobilier;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CreditImmobilier extends Credit {
    @Enumerated(EnumType.STRING)
    private TypeBienImmobilier typeBien;
}
