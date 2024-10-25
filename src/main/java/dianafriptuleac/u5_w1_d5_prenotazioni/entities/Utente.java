package dianafriptuleac.u5_w1_d5_prenotazioni.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "utenti")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter(AccessLevel.NONE)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "email")
    private String email;

    public Utente(String username, String fullName, String email) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
    }
}
