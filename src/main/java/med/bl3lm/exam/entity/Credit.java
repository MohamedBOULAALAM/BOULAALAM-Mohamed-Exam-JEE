package med.bl3lm.exam.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import med.bl3lm.exam.enums.StatutCredit;

import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // ou SINGLE_TABLE
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class Credit {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dateDemande;

    @Enumerated(EnumType.STRING)
    private StatutCredit statut;

    @Temporal(TemporalType.DATE)
    private Date dateAcception;

    private double montant;
    private int duree;
    private double tauxInteret;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "credit")
    private List<Remboursement> remboursements;
}