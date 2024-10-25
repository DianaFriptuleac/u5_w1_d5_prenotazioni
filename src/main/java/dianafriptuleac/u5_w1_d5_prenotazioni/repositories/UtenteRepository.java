package dianafriptuleac.u5_w1_d5_prenotazioni.repositories;

import dianafriptuleac.u5_w1_d5_prenotazioni.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

    boolean existsByEmail(String email);
}
