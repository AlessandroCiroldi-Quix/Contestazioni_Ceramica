package DAO;

import DTO.contestazioni_italcerDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;
import lombok.Data;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import java.util.List;
import java.util.Optional;

import static io.smallrye.config.ConfigLogging.log;

@ApplicationScoped
@Data
public class contestazioni_italcerDAO {
    @Inject
    Producer.jdbiProducer jdbiProducer;

    //* SELECT
    // Questa funzione restituisce i dati delle contestazioni italcer
    public List<contestazioni_italcerDTO> getData() {
        Jdbi jdbi = jdbiProducer.getJdbi();

        String query = "SELECT * FROM contestazioni_italcer";

        return jdbi.withHandle(handle -> handle.createQuery(query)
                .mapToBean(contestazioni_italcerDTO.class)
                .list()
        );
    }


    //* ADD
    // Metodo per aggiungere una contestazione
    @SuppressWarnings("unused")
    public void addContestazione_italcer(contestazioni_italcerDTO contestazione) {
        Jdbi jdbi = jdbiProducer.getJdbi(); // Otteniamo l'oggetto Jdbi dal produttore Jdbi

        String query = "INSERT INTO contestazioni_italcer VALUES (:id, :cod_cliente, :rs_cliente, :cod_articolo," +
                " :tono, :num_fattura, :data_fattura, :descrizione, :qta_contestata, :unita_misura, :posato, :stato," +
                " :utente_creazione, :data_creazione, :utente_ultima_mod, :data_ultima_mod, :desc_prodotto, :uid_files," +
                " :tipology, :motivazione, :company, :num_buono, :num_bolla, :num_ord_reparto, :difettosita, :deleted)";
        // Query SQL per inserire i dati nella tabella "contestazioni_italcer"

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
    public void deleteContestazione_italcer(contestazioni_italcerDTO contestazione) {
        Jdbi jdbi = jdbiProducer.getJdbi();  // Inizializza l'oggetto Jdbi utilizzando il jdbiProducer

        String query = "DELETE FROM contestazioni_italcer WHERE id = :id";  // Query per eliminare una riga dalla tabella 'contestazioni_italcer' basata sull'ID

        jdbi.useHandle(handle -> handle.createUpdate(query)  // Utilizza l'oggetto Handle per creare un'operazione di eliminazione
                .bind("id", contestazione.getId())  // Associa il valore dell'ID della contestazione al parametro nella query
                .execute()  // Esegue l'eliminazione
        );
    }


    //* FIND
    // Metodo per trovare una contestazione italcer
    public boolean findContestazione_italcer(contestazioni_italcerDTO contestazione) throws WebApplicationException {
        // Ottiene un'istanza di Jdbi dal jdbiProducer
        Jdbi jdbi = jdbiProducer.getJdbi();

        // Costruisce la stringa di query SQL per selezionare l'ID dalla tabella contestazioni_italcer
        String query = "SELECT id FROM contestazioni_italcer WHERE id = :id";

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
    // Metodo per aggiornare un record nella tabella 'contestazioni_italcer'
    public void updateContestazioni_italcer(contestazioni_italcerDTO contestazione, String id) {
        Jdbi jdbi = jdbiProducer.getJdbi(); // Ottiene l'oggetto Jdbi tramite jdbiProducer

        String query = "UPDATE contestazioni_italcer SET cod_cliente = :cod_cliente, rs_cliente = :rs_cliente, " +
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
            throw new WebApplicationException("Errore nell'aggiornamento della contestazione italcer.");
        }
    }
}
