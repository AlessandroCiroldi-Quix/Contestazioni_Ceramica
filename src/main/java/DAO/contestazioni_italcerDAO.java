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

    //NOME FUNZIONE DA CAMBIARE
    public List<contestazioni_italcerDTO> getData(){
        Jdbi jdbi = jdbiProducer.getJdbi();

        String query = "SELECT * FROM contestazioni_italcer";

        return jdbi.withHandle(handle -> handle.createQuery(query)
                .mapToBean(contestazioni_italcerDTO.class)
                .list()
        );
    }

}
