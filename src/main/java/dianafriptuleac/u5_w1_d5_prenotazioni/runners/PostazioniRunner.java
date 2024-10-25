package dianafriptuleac.u5_w1_d5_prenotazioni.runners;

import dianafriptuleac.u5_w1_d5_prenotazioni.entities.Edificio;
import dianafriptuleac.u5_w1_d5_prenotazioni.entities.Postazioni;
import dianafriptuleac.u5_w1_d5_prenotazioni.enums.TipoPostazione;
import dianafriptuleac.u5_w1_d5_prenotazioni.services.EdificioService;
import dianafriptuleac.u5_w1_d5_prenotazioni.services.PostazioniService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Slf4j
public class PostazioniRunner implements CommandLineRunner {

    @Autowired
    private PostazioniService postazioniService;


    @Autowired
    private EdificioService edificioService;

    @Override
    public void run(String... args) throws Exception {

        //mappa degli edifici x nome
        Map<String, Edificio> edificiMap = edificioService.findAll().stream()
                .collect(Collectors.toMap(Edificio::getNome, edificio -> edificio));

        List<Postazioni> postazioni = List.of(
                new Postazioni("Sala riunioni principale", TipoPostazione.RIUNIONI, 15, edificiMap.get("Talent Garden Isola")),
                new Postazioni("Biblioteca digitale", TipoPostazione.SALA, 80, edificiMap.get("Biblioteca Salaborsa")),
                new Postazioni("Zona relax e networking", TipoPostazione.OPENSPACE, 25, edificiMap.get("Copernico Centrale")),
                new Postazioni("Laboratorio creativo", TipoPostazione.PRIVATO, 10, edificiMap.get("Biblioteca Nazionale Centrale di Roma")),
                new Postazioni("Centro per eventi", TipoPostazione.FESTE, 150, edificiMap.get("Impact Hub Firenze"))
        );

/*
        postazioni.forEach(postazione -> {
            postazioniService.savePostazione(postazione);
            log.info("Postazione {} salvata correttamente per edificio {}", postazione.getDescrizione(), postazione.getEdificio().getNome());
        });
        */


        //Cerco la postazione per tipo e citta
        List<Postazioni> listPostazioni = postazioniService.findByTipoAndCitta(TipoPostazione.SALA, "Bologna");
        listPostazioni.forEach(postazione ->
                log.info("Le postazioni trovate:Descrizione: {}, Tipo: {}, Città: {} ", postazione.getDescrizione(), postazione.getTipoPostazione(), postazione.getEdificio().getCitta()));
    }
}
