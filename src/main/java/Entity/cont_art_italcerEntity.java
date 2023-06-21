package Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cont_art_italcer")
@Data
public class cont_art_italcerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cont;

    private String codArticolo;
    private String tono;
    private boolean posato;
    private String descProdotto;
    private String company;
    private String formato;
    private int qtaContestata;
    private String unitaMisura;


    // Costruttore

    /*
    public cont_art_italcerEntity(int id_Cont, String codArticolo, String tono, boolean posato,
                     String descProdotto, String company, String formato,
                     int qtaContestata, String unitaMisura) {
        this.id_cont = id_cont;
        this.codArticolo = codArticolo;
        this.tono = tono;
        this.posato = posato;
        this.descProdotto = descProdotto;
        this.company = company;
        this.formato = formato;
        this.qtaContestata = qtaContestata;
        this.unitaMisura = unitaMisura;
    }
    */
}
