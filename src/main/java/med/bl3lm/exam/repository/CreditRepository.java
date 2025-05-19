package med.bl3lm.exam.repository;

import med.bl3lm.exam.entity.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<Credit, Long> {
}
