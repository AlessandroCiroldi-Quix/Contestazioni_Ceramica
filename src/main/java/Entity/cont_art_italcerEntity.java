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

}
