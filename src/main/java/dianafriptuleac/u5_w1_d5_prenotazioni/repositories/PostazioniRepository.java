package dianafriptuleac.u5_w1_d5_prenotazioni.repositories;

import dianafriptuleac.u5_w1_d5_prenotazioni.entities.Postazioni;
import dianafriptuleac.u5_w1_d5_prenotazioni.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostazioniRepository extends JpaRepository<Postazioni, Long> {

    @Query("SELECT p FROM Postazioni p WHERE p.tipoPostazione = :tipo AND p.edificio.citta = :citta")
    List<Postazioni> findByTipoAndCitta(@Param("tipo") TipoPostazione tipo, @Param("citta") String citta);
}
