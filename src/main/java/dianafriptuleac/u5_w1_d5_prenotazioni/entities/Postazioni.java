package dianafriptuleac.u5_w1_d5_prenotazioni.entities;

import dianafriptuleac.u5_w1_d5_prenotazioni.enums.TipoPostazione;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "postazioni")
@Getter
@Setter
@NoArgsConstructor
public class Postazioni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter(AccessLevel.NONE)
    private long id;

    @Column(name = "descrizione")
    private String descrizione;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoPostazione")
    private TipoPostazione tipoPostazione;

    @Column(name = "max_occupanti")
    private long max_occupanti;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    public Postazioni(String descrizione, TipoPostazione tipoPostazione, long max_occupanti, Edificio edificio) {
        this.descrizione = descrizione;
        this.tipoPostazione = tipoPostazione;
        this.max_occupanti = max_occupanti;
        this.edificio = edificio;
    }

    @Override
    public String toString() {
        return "Postazioni{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                ", tipoPostazione=" + tipoPostazione +
                ", max_occupanti=" + max_occupanti +
                '}';
    }
}
