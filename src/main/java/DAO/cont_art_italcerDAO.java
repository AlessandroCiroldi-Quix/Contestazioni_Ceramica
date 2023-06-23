package DAO;

import DTO.cont_art_italcerDTO;
import DTO.contestazioni_italcerDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.Data;
import org.jdbi.v3.core.Jdbi;

import java.util.List;


@ApplicationScoped
@Data
public class cont_art_italcerDAO {
    @Inject
    Producer.jdbiProducer jdbiProducer;

    // Metodo per ottenere i dati
    @SuppressWarnings("unused")
    public List<cont_art_italcerDTO> getData() {
        // Ottieni un'istanza di Jdbi dal produttore jdbiProducer
        Jdbi jdbi = jdbiProducer.getJdbi();

        // Query per selezionare tutti i dati dalla tabella "contestazioni_italcer"
        String query = "SELECT * FROM contestazioni_italcer";

        // Esegui la query utilizzando Jdbi
        return jdbi.withHandle(handle -> handle.createQuery(query)  //* Handle rappresenta una connessione al database e consente di eseguire le operazioni sul database.
                // L'oggetto Query rappresenta la query SQL che verrà eseguita sul database. La query specificata è quella memorizzata nella variabile query
                .mapToBean(cont_art_italcerDTO.class) // Mappa i risultati della query a un oggetto cont_art_italcerDTO
                /*
                Questo metodo indica che i risultati della query devono essere mappati a un oggetto della classe cont_art_italcerDTO.
                La classe cont_art_italcerDTO contiene le proprietà che corrispondono alle colonne della tabella "contestazioni_italcer" nel database.
                 */
                .list() //Viene eseguita la query utilizzando l'oggetto Query e i risultati vengono restituiti come una lista di oggetti
        );
    }


    // Metodo per aggiungere una contestazione italcer al database
    @SuppressWarnings("unused")
    public void addCont_art_italcer(cont_art_italcerDTO contestazione) {
        // Ottieni un'istanza di Jdbi dal produttore jdbiProducer
        Jdbi jdbi = jdbiProducer.getJdbi();

        // Query per l'inserimento di una contestazione nella tabella "contestazioni_italcer"
        String query = "INSERT INTO contestazioni_italcer VALUES (:id_cont, :cod_articolo, :tono, :posato," +
                " :desc_prodotto, :company, :formato, :qta_contestata, :unita_misura)";

        // Esegui l'inserimento utilizzando Jdbi
        jdbi.withHandle(handle -> handle.createUpdate(query)
                // Associa i valori dei parametri della query ai campi dell'oggetto contestazione
                .bind("id_cont", contestazione.getId_cont())        //* I valori dei parametri della query vengono associati ai campi dell'oggetto
                .bind("cod_articolo", contestazione.getCodArticolo())
                .bind("tono", contestazione.getTono())
                .bind("posato", contestazione.getTono())
                .bind("desc_prodotto", contestazione.getDescProdotto())
                .bind("company", contestazione.getCompany())
                .bind("formato", contestazione.getFormato())
                .bind("qta_contestata", contestazione.getQtaContestata())
                .bind("unita_misura", contestazione.getUnitaMisura())
                .execute()
        );
    }

}
