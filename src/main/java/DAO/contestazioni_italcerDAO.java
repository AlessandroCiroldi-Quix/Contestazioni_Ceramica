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

    // Questa funzione aggiunge una contestazione italcer
    public void addContestazione_italcer(contestazioni_italcerDTO contestazione) {
        Jdbi jdbi = jdbiProducer.getJdbi();

        // Aggiungere i campi mancanti per l'inserimento della contestazione
        String query = "INSERT INTO contestazioni_italcer VALUES (:id, :rs_cliente)"; //!!!

        jdbi.withHandle(handle -> handle.createUpdate(query)
                .bind("id", contestazione.getId())
                .bind("rs_cliente", contestazione.getRs_cliente())
                // Aggiungere altri campi da aggiungere
                .execute()
        );

    }

}