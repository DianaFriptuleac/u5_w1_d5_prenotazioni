package dianafriptuleac.u5_w1_d5_prenotazioni.runners;

import dianafriptuleac.u5_w1_d5_prenotazioni.entities.Utente;
import dianafriptuleac.u5_w1_d5_prenotazioni.services.UtenteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class UtenteRunner implements CommandLineRunner {

    @Autowired
    private UtenteService utenteService;

    @Override
    public void run(String... args) throws Exception {
        List<Utente> utenti = List.of(
                new Utente("lucia88", "Lucia Bellini", "lucia.bellini@gmail.com"),
                new Utente("davideV3", "Davide Verdi", "davide.verdi@gmail.com"),
                new Utente("serenaP93", "Serena Palladini", "serena.palladini@gmail.com"),
                new Utente("giovanniM1", "Giovanni Marinelli", "giovanni.marinelli@gmail.com"),
                new Utente("antonioG68", "Antonio Gentile", "antonio.gentile@gmail.com")
        );

       /* utenti.forEach(utente -> {
            utenteService.saveUtente(utente);
            log.info("Utente {} salvato correttamente.", utente.getUsername());
        });
*/
    }
}
