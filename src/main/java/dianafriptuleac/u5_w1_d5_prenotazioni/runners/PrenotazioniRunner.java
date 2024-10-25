package dianafriptuleac.u5_w1_d5_prenotazioni.runners;

import dianafriptuleac.u5_w1_d5_prenotazioni.entities.Postazioni;
import dianafriptuleac.u5_w1_d5_prenotazioni.entities.Prenotazioni;
import dianafriptuleac.u5_w1_d5_prenotazioni.entities.Utente;
import dianafriptuleac.u5_w1_d5_prenotazioni.services.PostazioniService;
import dianafriptuleac.u5_w1_d5_prenotazioni.services.PrenotazioniService;
import dianafriptuleac.u5_w1_d5_prenotazioni.services.UtenteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class PrenotazioniRunner implements CommandLineRunner {
    @Autowired
    private PrenotazioniService prenotazioniService;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private PostazioniService postazioniService;

    @Override
    public void run(String... args) throws Exception {

        List<Utente> allUtenti = utenteService.findAll();
        List<Postazioni> allPostazioni = postazioniService.findAll();

        if (allUtenti.isEmpty() || allPostazioni.isEmpty()) {
            log.warn("Verifica i dati ne DB. Non ci sono utenti o postazioni salvate!");
            return;
        }

        try {
            //------------------------------------- 1. salvo 3 prenotazioni ---------------------------------------------
            // prenotazioniService.savePrenotazione(allUtenti.get(0), allPostazioni.get(0), LocalDate.now().plusDays(3));
            // prenotazioniService.savePrenotazione(allUtenti.get(1), allPostazioni.get(1), LocalDate.now().plusDays(2));
            //prenotazioniService.savePrenotazione(allUtenti.get(4), allPostazioni.get(4), LocalDate.now().plusDays(2));


            //------------------------------2. lo stesso utente, stessa postazione, un'altro giorno----------------------------------------
            // prenotazioniService.savePrenotazione(allUtenti.get(1), allPostazioni.get(1), LocalDate.now().plusDays(5));

            //------------------------------3. Un'altro utente, stessa postazione, stesso giorno-------------------------
            // prenotazioniService.savePrenotazione(allUtenti.get(3), allPostazioni.get(1), LocalDate.now().plusDays(2));

            //------------------------ 4. provo a salvare con lo stesso utente per lo stesso giorno -----------------------
            // prenotazioniService.savePrenotazione(allUtenti.get(1), allPostazioni.get(2), LocalDate.now().plusDays(2));


            //Lista delle mie prenotazioni
            List<Prenotazioni> prenotazioni = prenotazioniService.findAll();
            prenotazioni.forEach(prenotazione ->
                    log.info("Prenotazione salvata: Utente: {}, Postazione: {}, Data: {}",
                            prenotazione.getUtente().getUsername(),
                            prenotazione.getPostazione().getDescrizione(),
                            prenotazione.getDataPrenotazione())
            );

        } catch (Exception exception) {
            log.error("Errore durante il salvataggio: {}", exception.getMessage());
        }

    }
}
