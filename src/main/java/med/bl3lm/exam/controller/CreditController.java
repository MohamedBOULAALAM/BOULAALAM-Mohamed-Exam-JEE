package med.bl3lm.exam.controller;

import med.bl3lm.exam.dto.CreditDTO;
import med.bl3lm.exam.entity.Client;
import med.bl3lm.exam.entity.CreditPersonnel;
import med.bl3lm.exam.enums.StatutCredit;
import med.bl3lm.exam.mapper.CreditMapper;
import med.bl3lm.exam.repository.ClientRepository;
import med.bl3lm.exam.repository.CreditPersonnelRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/credits")
public class CreditController {

    private final CreditPersonnelRepository personnelRepo;
    private final ClientRepository clientRepo;

    public CreditController(CreditPersonnelRepository personnelRepo, ClientRepository clientRepo) {
        this.personnelRepo = personnelRepo;
        this.clientRepo = clientRepo;
    }

    @GetMapping
    @Operation(summary = "Lister tous les crédits personnels")
    public List<CreditDTO> getAllCredits() {
        return personnelRepo.findAll().stream()
                .map(CreditMapper::toDTO)
                .toList();
    }

    @PostMapping("/{clientId}")
    @Operation(summary = "Créer un crédit personnel pour un client")
    public CreditDTO createCredit(@PathVariable Long clientId, @RequestBody CreditDTO dto) {
        Client client = clientRepo.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        CreditPersonnel credit = CreditPersonnel.builder()
                .client(client)
                .dateDemande(new Date())
                .statut(StatutCredit.EN_COURS)
                .montant(dto.getMontant())
                .duree(dto.getDuree())
                .tauxInteret(dto.getTauxInteret())
                .motif("Etudes") // exemple temporaire
                .build();

        return CreditMapper.toDTO(personnelRepo.save(credit));
    }
}
