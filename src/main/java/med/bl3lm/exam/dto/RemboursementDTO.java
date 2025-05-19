package med.bl3lm.exam.dto;

import lombok.Data;

@Data
public class RemboursementDTO {
    private Long id;
    private String date;
    private double montant;
    private String type;
    private Long creditId;
}
