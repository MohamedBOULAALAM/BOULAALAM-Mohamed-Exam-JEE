package med.bl3lm.exam.dto;

import lombok.Data;

@Data
public class CreditDTO {
    private Long id;
    private String dateDemande;
    private String statut;
    private String dateAcception;
    private double montant;
    private int duree;
    private double tauxInteret;
    private Long clientId;
}
