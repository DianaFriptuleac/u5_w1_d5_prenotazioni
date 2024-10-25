package dianafriptuleac.u5_w1_d5_prenotazioni;

import dianafriptuleac.u5_w1_d5_prenotazioni.entities.Edificio;
import dianafriptuleac.u5_w1_d5_prenotazioni.repositories.EdificioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

@SpringBootTest
class U5W1D5PrenotazioniApplicationTests {

    @Autowired
    private U5W1D5PrenotazioniApplication context;

    @Autowired
    private EdificioRepository edificioRepository;

    @Test
    void contextLoads() {
        assertNotNull("Context", context);
    }

    @Test
    void findByNomeExistEdificio() {
        Optional<Edificio> edificio = edificioRepository.findByNome("Impact Hub Firenze");
        assertTrue(edificio.isPresent(), "L'edificio è presente");
        assertEquals("Firenze", edificio.get().getCitta(), "Firenze");
    }
}
