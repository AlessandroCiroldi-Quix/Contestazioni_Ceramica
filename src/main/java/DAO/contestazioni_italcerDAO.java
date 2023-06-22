package DAO;

import DTO.contestazioni_italcerDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.Data;
import org.jdbi.v3.core.Jdbi;

import java.util.List;

@ApplicationScoped
@Data
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

    //metodo per eliminare dati dalla tabella
    public void deleteContestazione_italcer(contestazioni_italcerDTO contestazione){

        Jdbi jdbi = jdbiProducer.getJdbi();

        String query = "DELETE FROM contestazione_italcer WHERE id = :id";

        jdbi.useHandle(handle -> handle.createUpdate(query)
                .bind("id", contestazione.getId())
                .execute()
        );
    }

}