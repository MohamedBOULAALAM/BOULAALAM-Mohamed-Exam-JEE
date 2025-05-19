package med.bl3lm.exam.mapper;

import med.bl3lm.exam.dto.RemboursementDTO;
import med.bl3lm.exam.entity.Remboursement;
import med.bl3lm.exam.entity.Credit;
import med.bl3lm.exam.enums.TypeRemboursement;

import java.text.SimpleDateFormat;

public class RemboursementMapper {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static RemboursementDTO toDTO(Remboursement r) {
        RemboursementDTO dto = new RemboursementDTO();
        dto.setId(r.getId());
        dto.setDate(sdf.format(r.getDate()));
        dto.setMontant(r.getMontant());
        dto.setType(r.getType().name());
        dto.setCreditId(r.getCredit().getId());
        return dto;
    }

    public static Remboursement toEntity(RemboursementDTO dto, Credit credit) {
        Remboursement r = new Remboursement();
        try {
            r.setDate(sdf.parse(dto.getDate()));
        } catch (Exception e) {
            throw new RuntimeException("Erreur parsing date", e);
        }
        r.setMontant(dto.getMontant());
        r.setType(TypeRemboursement.valueOf(dto.getType()));
        r.setCredit(credit);
        return r;
    }
}
