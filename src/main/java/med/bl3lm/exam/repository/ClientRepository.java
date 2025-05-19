package med.bl3lm.exam.repository;

import med.bl3lm.exam.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}

