package med.bl3lm.exam.mapper;

import med.bl3lm.exam.dto.CreditDTO;
import med.bl3lm.exam.entity.Credit;
import med.bl3lm.exam.entity.Client;
import med.bl3lm.exam.enums.StatutCredit;

import java.text.SimpleDateFormat;

public class CreditMapper {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static CreditDTO toDTO(Credit credit) {
        CreditDTO dto = new CreditDTO();
        dto.setId(credit.getId());
        dto.setDateDemande(sdf.format(credit.getDateDemande()));
        dto.setStatut(credit.getStatut().name());
        dto.setDateAcception(
                credit.getDateAcception() != null ? sdf.format(credit.getDateAcception()) : null
        );
        dto.setMontant(credit.getMontant());
        dto.setDuree(credit.getDuree());
        dto.setTauxInteret(credit.getTauxInteret());
        dto.setClientId(credit.getClient().getId());
        return dto;
    }

    public static Credit toEntity(CreditDTO dto, Client client) {
        Credit credit = new Credit() {}; // Utiliser une sous-classe concrète en pratique
        try {
            credit.setDateDemande(sdf.parse(dto.getDateDemande()));
            credit.setDateAcception(
                    dto.getDateAcception() != null ? sdf.parse(dto.getDateAcception()) : null
            );
        } catch (Exception e) {
            throw new RuntimeException("Erreur parsing date", e);
        }

        credit.setStatut(StatutCredit.valueOf(dto.getStatut()));
        credit.setMontant(dto.getMontant());
        credit.setDuree(dto.getDuree());
        credit.setTauxInteret(dto.getTauxInteret());
        credit.setClient(client);

        return credit;
    }
}
