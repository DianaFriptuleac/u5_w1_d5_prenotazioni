package dianafriptuleac.u5_w1_d5_prenotazioni.repositories;

import dianafriptuleac.u5_w1_d5_prenotazioni.entities.Postazioni;
import dianafriptuleac.u5_w1_d5_prenotazioni.entities.Prenotazioni;
import dianafriptuleac.u5_w1_d5_prenotazioni.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface PrenotazioniRepository extends JpaRepository<Prenotazioni, Long> {

    Optional<Prenotazioni> findByPostazioneAndDataPrenotazione(Postazioni postazioni, LocalDate dataPrenotazione);

    Optional<Prenotazioni> findByUtenteAndDataPrenotazione(Utente utente, LocalDate dataPrenotazione);

}
