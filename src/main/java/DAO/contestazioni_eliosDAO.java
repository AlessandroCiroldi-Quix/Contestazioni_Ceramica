package DAO;

import DTO.contestazioni_eliosDTO;

import DTO.eliosFiltroDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;
import lombok.Data;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.Query;

import java.util.List;
import java.util.Optional;

import static io.smallrye.config.ConfigLogging.log;

@ApplicationScoped
@Data
public class contestazioni_eliosDAO {
    @Inject
    Producer.jdbiProducer jdbiProducer;

    //* SELECT
    // Questa funzione restituisce i dati delle contestazioni elios
    public List<contestazioni_eliosDTO> getData() {
        Jdbi jdbi = jdbiProducer.getJdbi();

        String query = "SELECT * FROM contestazioni_elios";

        return jdbi.withHandle(handle -> handle.createQuery(query)
                .mapToBean(contestazioni_eliosDTO.class)
                .list()
        );
    }


    //* ADD
    // Metodo per aggiungere una contestazione
    @SuppressWarnings("unused")
    public void addContestazione_elios(contestazioni_eliosDTO contestazione) {
        Jdbi jdbi = jdbiProducer.getJdbi(); // Otteniamo l'oggetto Jdbi dal produttore Jdbi

        String query = "INSERT INTO contestazioni_elios VALUES (:id, :cod_cliente, :rs_cliente, :cod_articolo," +
                " :tono, :num_fattura, :data_fattura, :descrizione, :qta_contestata, :unita_misura, :posato, :stato," +
                " :utente_creazione, :data_creazione, :utente_ultima_mod, :data_ultima_mod, :desc_prodotto, :uid_files," +
                " :tipology, :motivazione, :company, :num_buono, :num_bolla, :num_ord_reparto, :difettosita, :deleted)";
        // Query SQL per inserire i dati nella tabella "contestazioni_elios"

        jdbi.withHandle(handle -> handle.createUpdate(query) // Eseguiamo una query di aggiornamento
                .bind("id", contestazione.getId()) // Assegniamo i valori dei parametri alla query
                .bind("cod_cliente", contestazione.getCod_cliente())
                .bind("rs_cliente", contestazione.getRs_cliente())
                .bind("cod_articolo", contestazione.getCod_articolo())
                .bind("tono", contestazione.getTono())
                .bind("num_fattura", contestazione.getNum_fattura())
                .bind("data_fattura", contestazione.getData_fattura())
                .bind("descrizione", contestazione.getDescrizione())
                .bind("qta_contestata", contestazione.getQta_contestata())
                .bind("unita_misura", contestazione.getUnita_misura())
                .bind("posato", contestazione.getPosato())
                .bind("stato", contestazione.getStato())
                .bind("utente_creazione", contestazione.getUtente_creazione())
                .bind("data_creazione", contestazione.getData_creazione())
                .bind("utente_ultima_mod", contestazione.getUtente_ultima_mod())
                .bind("data_ultima_mod", contestazione.getData_ultima_mod())
                .bind("desc_prodotto", contestazione.getDesc_prodotto())
                .bind("uid_files", contestazione.getUid_files())
                .bind("tipology", contestazione.getTipology())
                .bind("motivazione", contestazione.getMotivazione())
                .bind("company", contestazione.getCompany())
                .bind("num_buono", contestazione.getNum_buono())
                .bind("num_bolla", contestazione.getNum_bolla())
                .bind("num_ord_reparto", contestazione.getNum_ord_reparto())
                .bind("difettosita", contestazione.getDifettosita())
                .bind("deleted", contestazione.getDeleted())
                .execute() // Eseguiamo la query
        );
    }


    //* DELETE
    // Metodo per eliminare dati/elementi dalla tabella
    @SuppressWarnings("unused")
    public void deleteContestazione_elios(String id) {
        Jdbi jdbi = jdbiProducer.getJdbi();  // Inizializza l'oggetto Jdbi utilizzando il jdbiProducer

        String query = "DELETE FROM contestazioni_elios WHERE id = :id";  // Query per eliminare una riga dalla tabella 'contestazioni_elios' basata sull'ID

        jdbi.useHandle(handle -> handle.createUpdate(query)  // Utilizza l'oggetto Handle per creare un'operazione di eliminazione
                .bind("id", id)  // Associa il valore dell'ID della contestazione al parametro nella query
                .execute()  // Esegue l'eliminazione
        );
    }


    //* FIND
    // Metodo per trovare una contestazione elios
    public boolean findContestazione_elios(contestazioni_eliosDTO contestazione) throws WebApplicationException {
        // Ottiene un'istanza della classe Jdbi dal jdbiProducer
        Jdbi jdbi = jdbiProducer.getJdbi();

        // Costruisce la stringa di query SQL per selezionare l'ID dalla tabella contestazioni_elios
        String query = "SELECT id FROM contestazioni_elios WHERE id = :id";

        // Esegue la query e ottiene l'ID come Optional<String>
        Optional<String> id = jdbi.withHandle(handle -> handle.createQuery(query)
                .bind("id", contestazione.getId()) // Collega il valore dell'ID dell'oggetto contestazione al segnaposto ":id"
                .mapTo(String.class) // Indica che si desidera mappare il risultato della query in una stringa
                .findOne() // Esegue la query e restituisce al massimo un risultato
        );

        // Restituisce true se l'Optional<String> contiene un valore, altrimenti restituisce false
        return id.isPresent();
    }


    //* UPDATE
    //! N.B -> Devi inserire tutti i campi nel JSON, altrimenti genera Err:500
    // Metodo per aggiornare un record nella tabella 'contestazioni_elios'
    public void updateContestazioni_elios(contestazioni_eliosDTO contestazione, String id) {
        Jdbi jdbi = jdbiProducer.getJdbi(); // Ottiene l'oggetto Jdbi tramite jdbiProducer

        String query = "UPDATE contestazioni_elios SET cod_cliente = :cod_cliente, rs_cliente = :rs_cliente, " +
                "cod_articolo  = :cod_articolo , tono = :tono , num_fattura = :num_fattura , data_fattura= :data_fattura, " +
                "descrizione= :descrizione, qta_contestata= :qta_contestata, unita_misura = :unita_misura, " +
                "posato= :posato , stato= :stato , utente_creazione= :utente_creazione ,data_creazione = :data_creazione, " +
                "utente_ultima_mod = :utente_ultima_mod , data_ultima_mod= :data_ultima_mod ,desc_prodotto = :desc_prodotto, " +
                "uid_files = :uid_files , tipology= :tipology , motivazione= :motivazione, " +
                "company = :company ,num_buono = :num_buono , num_bolla= :num_bolla, num_ord_reparto= :num_ord_reparto, " +
                "difettosita= :difettosita ,deleted = :deleted WHERE id = :id";
        // Query di aggiornamento che modifica solo il campo 'cod_cliente'

        int rowsAffected = 0; // Dichiarazione e inizializzazione della variabile per il conteggio delle righe modificate

        try (Handle handle = jdbi.open()) {
            rowsAffected = handle.createUpdate(query)
                    .bind("cod_cliente", contestazione.getCod_cliente()) // Associa il valore di 'cod_cliente' al parametro nella query
                    .bind("rs_cliente", contestazione.getRs_cliente())
                    .bind("cod_articolo", contestazione.getCod_articolo())
                    .bind("tono", contestazione.getTono())
                    .bind("num_fattura", contestazione.getNum_fattura())
                    .bind("data_fattura", contestazione.getData_fattura())
                    .bind("descrizione", contestazione.getDescrizione())
                    .bind("qta_contestata", contestazione.getQta_contestata())
                    .bind("unita_misura", contestazione.getUnita_misura())
                    .bind("posato", contestazione.getPosato())
                    .bind("stato", contestazione.getStato())
                    .bind("utente_creazione", contestazione.getUtente_creazione())
                    .bind("data_creazione", contestazione.getData_creazione())
                    .bind("utente_ultima_mod", contestazione.getUtente_ultima_mod())
                    .bind("data_ultima_mod", contestazione.getData_ultima_mod())
                    .bind("desc_prodotto", contestazione.getDesc_prodotto())
                    .bind("uid_files", contestazione.getUid_files())
                    .bind("tipology", contestazione.getTipology())
                    .bind("motivazione", contestazione.getMotivazione())
                    .bind("company", contestazione.getCompany())
                    .bind("num_buono", contestazione.getNum_buono())
                    .bind("num_bolla", contestazione.getNum_bolla())
                    .bind("num_ord_reparto", contestazione.getNum_ord_reparto())
                    .bind("difettosita", contestazione.getDifettosita())
                    .bind("deleted", contestazione.getDeleted())
                    .bind("id", id) // Associa il valore dell'ID della contestazione al parametro nella query
                    .execute(); // Eseguiamo la query

        } catch (Exception e) {
            log.error(e.getMessage(), e); // Logga eventuali errori
        }

        if (rowsAffected != 1) {
            throw new WebApplicationException("Errore nell'aggiornamento della contestazione elios.");
        }
    }


    // Questo metodo prende un oggetto eliosFiltroDTO come input e restituisce una lista di oggetti contestazioni_eliosDTO.
    public List<contestazioni_eliosDTO> FiltroElios(eliosFiltroDTO contestazione) throws WebApplicationException {
        // Ottiene un'istanza di Jdbi dal jdbiProducer
        Jdbi jdbi = jdbiProducer.getJdbi();

        // Costruisce la stringa di query SQL per selezionare l'ID dalla tabella contestazioni_elios
        String query = "SELECT * FROM contestazioni_elios WHERE ";

        Boolean primo = false;


        if (contestazione.getId() > 0) {
            query += ", id = :id";
            if(!primo){ //se falso
                query = query.replace(",", "");
                primo = true;
            }
        }

        if (contestazione.getData_creazione() != null) {
            query += ", data_creazione = :data_creazione";
            if(!primo){ //se falso
                query = query.replace(",", "");
                primo = true;
            }
        }

        if (contestazione.getData_ultima_mod() != null) {
            query += ", data_ultima_mod = :data_ultima_mod";
            if(!primo){ //se falso
                query = query.replace(",", "");
                primo = true;
            }
        }

        if (contestazione.getCod_articolo() != "") {
            query += ", cod_articolo = :cod_articolo";
            if(!primo){ //se falso
                query = query.replace(",", "");
                primo = true;
            }
        }

        if (contestazione.getRs_cliente() != "") {

            query += ", rs_cliente = :rs_cliente";
            if(!primo){ //se falso
                query = query.replace(",", "");
                primo = true;
            }
        }

        if (contestazione.getStato() != "") {
            query += ", stato = :stato";
            if(!primo){ //se falso
                query = query.replace(",", "");
                primo = true;
            }
        }

        if (contestazione.getReparto() != "") {
            query += ", reparto = :reparto";
            if(!primo){ //se falso
                query = query.replace(",", "");
                primo = true;
            }
        }

        if (contestazione.getFormato() != "") {
            query += ", formato = :formato";
            if(!primo){ //se falso
                query = query.replace(",", "");
                primo = true;
            }
        }

        if (contestazione.getUtente_creazione() != "") {
            query += ", utente_creazione = :utente_creazione";
            if(!primo){ //se falso
                query = query.replace(",", "");
                primo = true;
            }
        }


        // Esegue la query e ottiene l'ID come Optional<String>
        // Utilizzando withHandle(), si ottiene una connessione al database gestita automaticamente.
        // Si prepara la query utilizzando il segnaposto ":id" e si collega il valore dell'ID dell'oggetto contestazione.
        // La query restituirà una lista di oggetti contestazioni_eliosDTO mappati automaticamente dalla query SQL.
        String finalQuery = query;
        return jdbi.withHandle(handle -> {
            Query q = handle.createQuery(finalQuery);
            if (contestazione.getId() > 0) {
                q.bind("id", contestazione.getId());
            }

            if (contestazione.getData_creazione() != null) {
                q.bind("data_creazione", contestazione.getData_creazione());
            }

            if (contestazione.getData_ultima_mod() != null) {
                q.bind("data_ultima_modifica", contestazione.getData_ultima_mod());
            }

            if (contestazione.getCod_articolo() != "") {
                q.bind("cod_articolo", contestazione.getCod_articolo());
            }

            if (contestazione.getRs_cliente() != "") {
                q.bind("rs_cliente", contestazione.getRs_cliente());
            }

            if (contestazione.getStato() != "") {
                q.bind("stato", contestazione.getStato());
            }

            if (contestazione.getReparto() != "") {
                q.bind("reparto", contestazione.getReparto());
            }

            if (contestazione.getFormato() != "") {
                q.bind("formato", contestazione.getFormato());
            }

            if (contestazione.getUtente_creazione() != "") {
                q.bind("utente_creazione", contestazione.getUtente_creazione());
            }

            return q.mapToBean(contestazioni_eliosDTO.class) // Mappa i risultati della query all'oggetto contestazioni_eliosDTO.
                    .list();
        });
    }
}
