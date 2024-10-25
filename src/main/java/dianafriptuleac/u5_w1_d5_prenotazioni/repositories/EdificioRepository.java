package dianafriptuleac.u5_w1_d5_prenotazioni.repositories;

import dianafriptuleac.u5_w1_d5_prenotazioni.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EdificioRepository extends JpaRepository<Edificio, Long> {

    boolean existsByNome(String nome);

    Optional<Edificio> findByNome(String nome);


}
