package dianafriptuleac.u5_w1_d5_prenotazioni.services;

import dianafriptuleac.u5_w1_d5_prenotazioni.entities.Utente;
import dianafriptuleac.u5_w1_d5_prenotazioni.exceptions.ValidationException;
import dianafriptuleac.u5_w1_d5_prenotazioni.repositories.UtenteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public void saveUtente(Utente newUtente) {
        if (newUtente.getUsername() == null || newUtente.getUsername().isEmpty()) {
            throw new ValidationException("Lo username del utente non può essere vuoto");
        }
        if (newUtente.getFullName().length() < 2) {
            throw new ValidationException("Il fullName del utente non può essere più corto di due caratteri");
        }
        if (utenteRepository.existsByEmail(newUtente.getEmail()))
            throw new ValidationException("Email utente già in uso!");

        utenteRepository.save(newUtente);
        log.info("Utente salvato con successo: {}", newUtente);
    }


    public List<Utente> findAll() {
        return utenteRepository.findAll();
    }
}

