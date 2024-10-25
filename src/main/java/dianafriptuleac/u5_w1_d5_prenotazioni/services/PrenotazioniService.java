package dianafriptuleac.u5_w1_d5_prenotazioni.services;

import dianafriptuleac.u5_w1_d5_prenotazioni.entities.Postazioni;
import dianafriptuleac.u5_w1_d5_prenotazioni.entities.Prenotazioni;
import dianafriptuleac.u5_w1_d5_prenotazioni.entities.Utente;
import dianafriptuleac.u5_w1_d5_prenotazioni.exceptions.ValidationException;
import dianafriptuleac.u5_w1_d5_prenotazioni.repositories.PrenotazioniRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PrenotazioniService {

    @Autowired
    PrenotazioniRepository prenotazioniRepository;

    public void savePrenotazione(Utente utente, Postazioni postazioni, LocalDate dataPrenotazione) {
        //Controllo se la postazione e gia prenotata
        Optional<Prenotazioni> prenotazioneEsistente = prenotazioniRepository.
                findByPostazioneAndDataPrenotazione(postazioni, dataPrenotazione);
        if (prenotazioneEsistente.isPresent()) {
            throw new ValidationException("La postazione è già occupata per questa data");
        }
        //Controllo se l'utente ha gia una prenotazione per quella data
        Optional<Prenotazioni> prenotazioneUtente = prenotazioniRepository.
                findByUtenteAndDataPrenotazione(utente, dataPrenotazione);
        if (prenotazioneUtente.isPresent()) {
            throw new ValidationException("Hai già una prenotazione per questa data! Seleziona un altro giorno!");
        }
        Prenotazioni newPrenotazione = new Prenotazioni(dataPrenotazione, utente, postazioni);
        prenotazioniRepository.save(newPrenotazione);
    }

    public List<Prenotazioni> findAll() {
        return prenotazioniRepository.findAll();
    }
}
