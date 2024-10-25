package dianafriptuleac.u5_w1_d5_prenotazioni.services;

import dianafriptuleac.u5_w1_d5_prenotazioni.entities.Edificio;
import dianafriptuleac.u5_w1_d5_prenotazioni.exceptions.ValidationException;
import dianafriptuleac.u5_w1_d5_prenotazioni.repositories.EdificioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EdificioService {
    @Autowired
    public EdificioRepository edificioRepository;

    public void saveEdificio(Edificio newEdificio) {
        if (newEdificio.getNome() == null || newEdificio.getNome().isEmpty()) {
            throw new ValidationException("Il nome dell'edificio non può essere vuoto");
        }
        if (newEdificio.getIndirizzo() == null || newEdificio.getIndirizzo().isEmpty()) {
            throw new ValidationException("L'indirizzo dell'edificio non può essere vuoto");
        }
        if (newEdificio.getCitta() == null || newEdificio.getCitta().isEmpty()) {
            throw new ValidationException("La città dell'edificio non può essere un campo vuoto");
        }
        if (edificioRepository.existsByNome(newEdificio.getNome())) {
            throw new ValidationException("Esiste già un edificio con lo stesso nome, cambiare il nome.");
        }

        edificioRepository.save(newEdificio);
        log.info("Edificio salvato con successo: " + newEdificio);
    }

    public List<Edificio> findAll() {
        return edificioRepository.findAll();
    }
}
