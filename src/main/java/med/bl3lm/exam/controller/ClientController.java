package med.bl3lm.exam.controller;

import med.bl3lm.exam.dto.ClientDTO;
import med.bl3lm.exam.entity.Client;
import med.bl3lm.exam.mapper.ClientMapper;
import med.bl3lm.exam.repository.ClientRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping
    @Operation(summary = "Lister tous les clients")
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream()
                .map(ClientMapper::toDTO)
                .toList();
    }

    @PostMapping
    @Operation(summary = "Créer un nouveau client")
    public ClientDTO createClient(@RequestBody ClientDTO dto) {
        Client client = ClientMapper.toEntity(dto);
        return ClientMapper.toDTO(clientRepository.save(client));
    }
}
