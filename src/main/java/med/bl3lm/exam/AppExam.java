package med.bl3lm.exam;

import med.bl3lm.exam.entity.*;
import med.bl3lm.exam.enums.*;
import med.bl3lm.exam.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Date;

@SpringBootApplication
public class AppExam {

    public static void main(String[] args) {
        SpringApplication.run(AppExam.class, args);
    }

    @Bean
    CommandLineRunner start(
            ClientRepository clientRepo,
            CreditPersonnelRepository personnelRepo,
            CreditImmobilierRepository immobilierRepo,
            CreditProfessionnelRepository professionnelRepo,
            RemboursementRepository remboursementRepo
    ) {
        return args -> {
            // 🔹 Client
            Client client1 = Client.builder().nom("Mohamed").email("mohamed@bl3lm.med").build();
            client1 = clientRepo.save(client1);

            // 🔹 Crédit Personnel
            CreditPersonnel cp = CreditPersonnel.builder()
                    .client(client1)
                    .dateDemande(new Date())
                    .statut(StatutCredit.EN_COURS)
                    .montant(50000)
                    .duree(24)
                    .tauxInteret(4.5)
                    .motif("Achat voiture")
                    .build();
            personnelRepo.save(cp);

            // 🔹 Crédit Immobilier
            CreditImmobilier ci = CreditImmobilier.builder()
                    .client(client1)
                    .dateDemande(new Date())
                    .statut(StatutCredit.ACCEPTE)
                    .montant(300000)
                    .duree(120)
                    .tauxInteret(3.8)
                    .typeBien(TypeBienImmobilier.MAISON)
                    .dateAcception(new Date())
                    .build();
            immobilierRepo.save(ci);

            // 🔹 Crédit Professionnel
            CreditProfessionnel cpro = CreditProfessionnel.builder()
                    .client(client1)
                    .dateDemande(new Date())
                    .statut(StatutCredit.REJETE)
                    .motif("Création startup")
                    .raisonSociale("InnovaTech SARL")
                    .montant(150000)
                    .duree(36)
                    .tauxInteret(5.2)
                    .build();
            professionnelRepo.save(cpro);

            // 🔹 Remboursement
            Remboursement r1 = Remboursement.builder()
                    .credit(cp)
                    .date(new Date())
                    .montant(2000)
                    .type(TypeRemboursement.MENSUALITE)
                    .build();
            remboursementRepo.save(r1);

            System.out.println("Données de test insérées avec succès.");
        };
    }
}
