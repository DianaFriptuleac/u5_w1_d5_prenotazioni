package dianafriptuleac.u5_w1_d5_prenotazioni.repositories;

import dianafriptuleac.u5_w1_d5_prenotazioni.entities.Postazioni;
import dianafriptuleac.u5_w1_d5_prenotazioni.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostazioniRepository extends JpaRepository<Postazioni, Long> {

    //Custom query-JPQL - cerco postazioni per tipo e citta
    @Query("SELECT p FROM Postazioni p WHERE p.tipoPostazione = :tipo AND p.edificio.citta = :citta")
    List<Postazioni> findByTipoAndCitta(TipoPostazione tipo, String citta);
}
