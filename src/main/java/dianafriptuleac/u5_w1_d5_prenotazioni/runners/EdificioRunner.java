package dianafriptuleac.u5_w1_d5_prenotazioni.runners;

import dianafriptuleac.u5_w1_d5_prenotazioni.entities.Edificio;
import dianafriptuleac.u5_w1_d5_prenotazioni.services.EdificioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class EdificioRunner implements CommandLineRunner {
    @Autowired
    private EdificioService edificioService;

    @Override
    public void run(String... args) throws Exception {
        List<Edificio> edifici = List.of(
                new Edificio("Talent Garden Isola", "Via Arcivescovo Calabiana 6", "Milano"),
                new Edificio("Biblioteca Salaborsa", "Piazza Nettuno 3", "Bologna"),
                new Edificio("Copernico Centrale", "Via Copernico 38", "Milano"),
                new Edificio("Biblioteca Nazionale Centrale di Roma", "Viale Castro Pretorio 105", "Roma"),
                new Edificio("Impact Hub Firenze", "Via Panciatichi 16", "Firenze")
        );

       /* edifici.forEach(edificio -> {
            edificioService.saveEdificio(edificio);
            log.info("Edificio {} salvato correttamente.", edificio.getNome());
        });*/
    }
}
