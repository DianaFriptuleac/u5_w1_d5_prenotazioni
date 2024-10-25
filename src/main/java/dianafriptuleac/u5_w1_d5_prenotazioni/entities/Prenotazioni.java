package dianafriptuleac.u5_w1_d5_prenotazioni.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "prenotazioni")
@Getter
@Setter
@NoArgsConstructor
public class Prenotazioni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter(AccessLevel.NONE)
    private long id;

    @Column(name = "data_prenotazione")
    private LocalDate dataPrenotazione;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "postazione_id")
    private Postazioni postazione;

    public Prenotazioni(LocalDate data_prenotazione, Utente utente, Postazioni postazione) {
        this.dataPrenotazione = data_prenotazione;
        this.utente = utente;
        this.postazione = postazione;
    }

    @Override
    public String toString() {
        return "Prenotazioni{" +
                "id=" + id +
                ", data_prenotazione=" + dataPrenotazione +
                '}';
    }
}
