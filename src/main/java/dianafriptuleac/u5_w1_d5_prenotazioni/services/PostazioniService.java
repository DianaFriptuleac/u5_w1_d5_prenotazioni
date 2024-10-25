package dianafriptuleac.u5_w1_d5_prenotazioni.services;

import dianafriptuleac.u5_w1_d5_prenotazioni.entities.Postazioni;
import dianafriptuleac.u5_w1_d5_prenotazioni.exceptions.ValidationException;
import dianafriptuleac.u5_w1_d5_prenotazioni.repositories.EdificioRepository;
import dianafriptuleac.u5_w1_d5_prenotazioni.repositories.PostazioniRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostazioniService {
    @Autowired
    private PostazioniRepository postazioniRepository;

    @Autowired
    private EdificioRepository edificioRepository;

    public void savePostazione(Postazioni newPostazione) {
        if (newPostazione.getDescrizione() == null || newPostazione.getDescrizione().isEmpty()) {
            throw new ValidationException("La descrizione della postazione non può essere vuota");
        }
        if (newPostazione.getTipoPostazione() == null) {
            throw new ValidationException("Il tipo di postazione deve essere specificato");
        }
        if (newPostazione.getMax_occupanti() <= 0) {
            throw new ValidationException("Il numero massimo di occupanti deve essere maggiore di zero");
        }
        if (newPostazione.getEdificio() == null) {
            throw new ValidationException("La postazione deve essere associata a un edificio");
        }

        postazioniRepository.save(newPostazione);
        log.info("Postazione salvata con successo: {}", newPostazione);
    }

    public List<Postazioni> findAll() {
        return postazioniRepository.findAll();
    }
}
