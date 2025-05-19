package med.bl3lm.exam.repository;

import med.bl3lm.exam.entity.Remboursement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemboursementRepository extends JpaRepository<Remboursement, Long> {
}