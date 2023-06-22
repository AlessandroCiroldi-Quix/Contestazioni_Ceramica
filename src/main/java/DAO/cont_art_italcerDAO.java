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

    @SuppressWarnings("unused")
    public List<cont_art_italcerDTO> getData() {
        Jdbi jdbi = jdbiProducer.getJdbi();

        String query = "SELECT * FROM contestazioni_italcer";

        return jdbi.withHandle(handle -> handle.createQuery(query)
                .mapToBean(cont_art_italcerDTO.class)
                .list()
        );
    }

    // Questa funzione aggiunge una contestazione italcer
    @SuppressWarnings("unused")
    public void addCont_art_italcer(cont_art_italcerDTO contestazione) {
        Jdbi jdbi = jdbiProducer.getJdbi();

        // Aggiungere i campi mancanti per l'inserimento della contestazione
        String query = "INSERT INTO contestazioni_italcer VALUES (:id_cont, :cod_articolo, :tono, :posato, :desc_prodotto, :company, :formato, :qta_contestata, :unita_misura)"; //!!!

        jdbi.withHandle(handle -> handle.createUpdate(query)
                // Campi della tabella a cui accedere!
                .bind("id_cont", contestazione.getId_cont())
                .bind("cod_articolo", contestazione.getCodArticolo())
                .bind("tono", contestazione.getTono())
                .bind("posato", contestazione.getTono())
                .bind("desc_prodotto", contestazione.getDescProdotto())
                .bind("company", contestazione.getCompany())
                .bind("formato", contestazione.getFormato())//
                .bind("qta_contestata", contestazione.getQtaContestata())
                .bind("unita_misura", contestazione.getUnitaMisura())
                .execute()
        );

    }

}
