package Producer;
import org.jdbi.v3.core.Jdbi;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class jdbiProducer {
    Jdbi jdbi;

    jdbiProducer(){ jdbi = Jdbi.create("jdbc:mysql://localhost:3306/contestazioni","root","Quix2905!"); }
    public Jdbi getJdbi(){
        return jdbi;
    }
    /* Il costruttore inizializza un'istanza jdbi per creare la connessione al db
     * il metodo pubblico 'getJdbi' rende l'istanza jdbi utilizzabile anche in altre classi */
}
