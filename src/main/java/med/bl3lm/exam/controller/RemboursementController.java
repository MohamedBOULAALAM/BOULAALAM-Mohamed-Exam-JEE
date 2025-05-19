package med.bl3lm.exam.controller;

import med.bl3lm.exam.dto.RemboursementDTO;
import med.bl3lm.exam.entity.Credit;
import med.bl3lm.exam.entity.Remboursement;
import med.bl3lm.exam.mapper.RemboursementMapper;
import med.bl3lm.exam.repository.CreditRepository;
import med.bl3lm.exam.repository.RemboursementRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/remboursements")
public class RemboursementController {

    private final RemboursementRepository remboursementRepo;
    private final CreditRepository creditRepo;

    public RemboursementController(RemboursementRepository remboursementRepo, CreditRepository creditRepo) {
        this.remboursementRepo = remboursementRepo;
        this.creditRepo = creditRepo;
    }

    @PostMapping("/{creditId}")
    @Operation(summary = "Ajouter un remboursement à un crédit")
    public RemboursementDTO addRemboursement(
            @PathVariable Long creditId,
            @RequestBody RemboursementDTO dto) {

        Credit credit = creditRepo.findById(creditId)
                .orElseThrow(() -> new RuntimeException("Crédit introuvable"));

        Remboursement r = RemboursementMapper.toEntity(dto, credit);
        return RemboursementMapper.toDTO(remboursementRepo.save(r));
    }

    @GetMapping("/{creditId}")
    @Operation(summary = "Lister les remboursements d’un crédit")
    public List<RemboursementDTO> getByCredit(@PathVariable Long creditId) {
        Credit credit = creditRepo.findById(creditId)
                .orElseThrow(() -> new RuntimeException("Crédit introuvable"));

        return remboursementRepo.findAll().stream()
                .filter(r -> r.getCredit().getId().equals(creditId))
                .map(RemboursementMapper::toDTO)
                .toList();
    }
}
