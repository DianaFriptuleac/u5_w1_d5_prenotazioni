# Prenotazioni

### Descrizione del Progetto
Prenotazioni rapresenta un'applicazione Spring Boot proggettata per gestire le prenotazioni di postazioni aziendali.
Gli utenti possono effettuare prenotazioni giornaliere, se la postazione scelta è disponibile e cercare le postazioni per tipo e città.

### Architettura del Progetto
L’applicazione utilizza Spring Boot e Spring Data JPA per la persistenza dei dati, con un database (u5_w1_d5_prenotazioni) PostgreSQL configurato nel file application.properties.
Le entità principali sono Edificio, Postazioni, Utente e Prenotazioni.

### Mapping
1.**Postazioni** Include un campo tipoPostazione (enum con valori PRIVATO, OPENSPACE, SALA, RIUNIONI, FESTE) e una relazione Many-to-One con Edificio, perche un Edificio può contenere più postazioni.
2.**Utente** Un utente può fare più prenotazioni, quindi ha una relazione One-to-Many con Prenotazioni.
3.**Prenotazioni**: Sono associate ad un Utente e una Postazione tramite una relazione Many-to-One.

#### Persistenza e Relazioni
Ogni entità ha un repository dedicato (EdificioRepository, PostazioniRepository, UtenteRepository, PrenotazioniRepository) per la gestione delle operazioni CRUD e query.

### Funzioni Principali
1. **saveEdificio(Edificio newEdificio) - (in EdificioService)**:
   Salva un nuovo edificio nel db. Esegue controlli di validazione per assicurarsi che il nome, l’indirizzo e la città siano presenti e che non esista già un edificio con lo stesso nome.
2. **findAll() - (in EdificioService, PostazioniService, UtenteService, PrenotazioniService)**:
   Recupera e restituisce tutti gli edifici, postazioni, utenti o prenotazioni disponibili.
3. **savePostazione(Postazioni newPostazione) - (in PostazioniService)**:
Salva una nuova postazione dopo aver verificato che tutti i campi richiesti siano presenti.
4. **findByTipoAndCitta(TipoPostazione tipoPostazione, String citta) - (in PostazioniService)**:
Ricerca le postazioni in base al tipo e alla città specificati, utilizzando una custom query. Restituisce la lista di postazioni corrispondenti.
5. **savePrenotazione(Utente utente, Postazioni postazioni, LocalDate dataPrenotazione) - (in PrenotazioniService)**
Salva una prenotazione per una postazione e una data specifica, dopo aver controllato che la postazione sia libera e che l’utente non abbia altre prenotazioni nella stessa data.
6. **existsByNome(String nome) - (in EdificioRepository)**
Verifica se esiste già un edificio con un determinato nome per evitare duplicati.
7. **findByPostazioneAndDataPrenotazione(Postazioni postazioni, LocalDate dataPrenotazione) - (in PrenotazioniRepository)**
Controlla se una determinata postazione è già prenotata per una data specifica.
8. **findByUtenteAndDataPrenotazione(Utente utente, LocalDate dataPrenotazione) - (in PrenotazioniRepository)**
Verifica se un utente ha già una prenotazione per una determinata data, per garantire che l'utente non possa prenotare più di una postazione lo stesso giorno.
  

