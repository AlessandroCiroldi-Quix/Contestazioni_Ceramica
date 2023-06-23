package DAO;

import DTO.contestazioni_italcerDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;
import lombok.Data;
import org.jdbi.v3.core.Jdbi;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Data
@SuppressWarnings("nome_warning")       // Per eliminare i warning
public class contestazioni_italcerDAO {
    @Inject
    Producer.jdbiProducer jdbiProducer;

    // Questa funzione restituisce i dati delle contestazioni italcer
    public List<contestazioni_italcerDTO> getData() {
        Jdbi jdbi = jdbiProducer.getJdbi();


        String query = "SELECT * FROM contestazioni_italcer";

        return jdbi.withHandle(handle -> handle.createQuery(query)
                .mapToBean(contestazioni_italcerDTO.class)
                .list()
        );
    }

    // metodo per aggiungere una contestazione
    @SuppressWarnings("unused")
    public void addContestazione_italcer(contestazioni_italcerDTO contestazione) {
        Jdbi jdbi = jdbiProducer.getJdbi();

        String query = "INSERT INTO contestazioni_italcer VALUES (:id, :cod_cliente, :rs_cliente, :cod_articolo," +
                " :tono, :num_fattura, :data_fattura, :descrizione, :qta_contestata, :unita_misura, :posato, :stato," +
                " :utente_creazione, :data_creazione, :utente_ultima_mod, :data_ultima_mod, :desc_prodotto, :uid_files," +
                " :tipology, :motivazione, :company, :num_buono, :num_bolla, :num_ord_reparto, :difettosita, :deleted)";

        jdbi.withHandle(handle -> handle.createUpdate(query)
                .bind("id", contestazione.getId())
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
                .execute()
        );
    }

    // Metodo per eliminare dati dalla tabella "contestazioni_italcer"
    @SuppressWarnings("unused")
    public void deleteContestazione_italcer(contestazioni_italcerDTO contestazione) {

        // Ottenere l'istanza di Jdbi dal produttore JdbiProducer
        Jdbi jdbi = jdbiProducer.getJdbi();

        // Query per eliminare una riga dalla tabella "contestazioni_italcer" in base all'ID
        String query = "DELETE FROM contestazioni_italcer WHERE id = :id";

        // Utilizzare l'istanza di Jdbi per eseguire la query di eliminazione
        jdbi.useHandle(handle -> handle.createUpdate(query)
                .bind("id", contestazione.getId())
                .execute()
        );
    }

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

}