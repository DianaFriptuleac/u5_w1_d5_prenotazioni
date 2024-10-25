package dianafriptuleac.u5_w1_d5_prenotazioni.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Long id) {
        super("Nessun elemento trovato con questo id!");
    }
}
