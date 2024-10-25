package dianafriptuleac.u5_w1_d5_prenotazioni.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "edificio")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter(AccessLevel.NONE)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "citta")
    private String citta;

    public Edificio(String nome, String indirizzo, String citta) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.citta = citta;
    }
}
