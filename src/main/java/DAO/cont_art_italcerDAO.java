package DAO;

import DTO.cont_art_italcerDTO;
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
public class cont_art_italcerDAO {
    @Inject
    Producer.jdbiProducer jdbiProducer;

    //* SELECT
    // Questa funzione restituisce i dati delle cont_art_italcer
    public List<cont_art_italcerDTO> getData() {
        Jdbi jdbi = jdbiProducer.getJdbi();

        String query = "SELECT * FROM cont_art_italcer";

        return jdbi.withHandle(handle -> handle.createQuery(query)
                .mapToBean(cont_art_italcerDTO.class)
                .list()
        );
    }


    //* ADD
    // Metodo per aggiungere una contestazione
    @SuppressWarnings("unused")
    public void addCont_art_italcer(cont_art_italcerDTO contestazione) {
        Jdbi jdbi = jdbiProducer.getJdbi(); // Otteniamo l'oggetto Jdbi dal produttore Jdbi

        String query = "INSERT INTO contestazioni.cont_art_italcer (id_cont, cod_articolo, tono, posato, desc_prodotto," +
                " company, formato, qta_contestata, unita_misura) VALUES ( :id_cont, :cod_articolo, :tono, :posato, :desc_prodotto," +
                " :company, :formato, :qta_contestata, :unita_misura)";
        // Query SQL per inserire i dati nella tabella "cont_art_italcer"

        jdbi.withHandle(handle -> handle.createUpdate(query) // Eseguiamo una query di aggiornamento
                .bind("id_cont", contestazione.getId_cont())        // I valori dei parametri della query vengono associati ai campi dell'oggetto
                .bind("cod_articolo", contestazione.getCod_articolo())
                .bind("tono", contestazione.getTono())
                .bind("posato", contestazione.isPosato())
                .bind("desc_prodotto", contestazione.getDescProdotto())
                .bind("company", contestazione.getCompany())
                .bind("formato", contestazione.getFormato())
                .bind("qta_contestata", contestazione.getQtaContestata())
                .bind("unita_misura", contestazione.getUnita_misura())
                .execute()
        );
    }



    //* DELETE
    // Metodo per eliminare dati/elementi dalla tabella
    @SuppressWarnings("unused")
    public void deleteCont_art_italcer(cont_art_italcerDTO contestazione) {
        Jdbi jdbi = jdbiProducer.getJdbi();  // Inizializza l'oggetto Jdbi utilizzando il jdbiProducer

        String query = "DELETE FROM cont_art_italcer WHERE id_cont = :id_cont";  // Query per eliminare una riga dalla tabella 'cont_art_italcer' basata sull'id_cont

        jdbi.useHandle(handle -> handle.createUpdate(query)  // Utilizza l'oggetto Handle per creare un'operazione di eliminazione
                .bind("id_cont", contestazione.getId_cont())  // Associa il valore dell'ID della contestazione al parametro nella query
                .execute()  // Esegue l'eliminazione
        );
    }


    //* FIND
    @SuppressWarnings("unused")
    // Metodo per trovare una contestazione italcer
    public boolean findCont_art_Italcer(cont_art_italcerDTO contestazione) throws WebApplicationException {
        // Ottiene un'istanza di Jdbi dal jdbiProducer
        Jdbi jdbi = jdbiProducer.getJdbi();

        // Costruisce la stringa di query SQL per selezionare l'ID dalla tabella cont_art_italcer
        String query = "SELECT id_cont FROM cont_art_italcer WHERE id_cont = :id_cont";

        // Esegue la query e ottiene l'id_cont come Optional<String>
        Optional<String> id_cont = jdbi.withHandle(handle -> handle.createQuery(query)
                .bind("id_cont", contestazione.getId_cont()) // Collega il valore dell'ID dell'oggetto contestazione al segnaposto ":id"
                .mapTo(String.class) // Indica che si desidera mappare il risultato della query in una stringa
                .findOne() // Esegue la query e restituisce al massimo un risultato
        );

        // Restituisce true se l'Optional<String> contiene un valore, altrimenti restituisce false
        return id_cont.isPresent();
    }


    //* UPDATE
    // N.B -> Devi inserire tutti i campi nel JSON, altrimenti genera Err:500
    // Metodo per aggiornare un record nella tabella 'cont_art_italcer'
    @SuppressWarnings("unused")
    public void updatecont_art_italcer(cont_art_italcerDTO contestazione, String id_cont) {
        Jdbi jdbi = jdbiProducer.getJdbi(); // Ottiene l'oggetto Jdbi tramite jdbiProducer

        String query = "UPDATE cont_art_italcer SET cod_articolo = :cod_articolo, tono = :tono," +
                " posato = :posato, desc_prodotto = :desc_prodotto, company = :company, formato = :formato," +
                " qta_contestata = :qta_contestata, unita_misura = :unita_misura WHERE id_cont = :id_cont";
        // Query di aggiornamento che modifica solo il campo 'cod_cliente'

        int rowsAffected = 0; // Dichiarazione e inizializzazione della variabile per il conteggio delle righe modificate

        try (Handle handle = jdbi.open()) {
            rowsAffected = handle.createUpdate(query)
                    .bind("id_cont", contestazione.getId_cont())        //* I valori dei parametri della query vengono associati ai campi dell'oggetto
                    .bind("cod_articolo", contestazione.getCod_articolo())
                    .bind("tono", contestazione.getTono())
                    .bind("posato", contestazione.isPosato())
                    .bind("desc_prodotto", contestazione.getDescProdotto())
                    .bind("company", contestazione.getCompany())
                    .bind("formato", contestazione.getFormato())
                    .bind("qta_contestata", contestazione.getQtaContestata())
                    .bind("unita_misura", contestazione.getUnita_misura())
                    .execute();
        } catch (Exception e) {
            log.error(e.getMessage(), e); // Logga eventuali errori
        }

        if (rowsAffected != 1) {
            throw new WebApplicationException("Errore nell'aggiornamento della contestazione italcer.");
        }
    }
}
