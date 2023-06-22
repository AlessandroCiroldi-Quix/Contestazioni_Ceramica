package Entity;

import io.smallrye.common.constraint.NotNull;
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
    @NotNull
    int id_cont;

    @NotNull
    String cod_articolo;
    @NotNull
    String tono;
    @NotNull
    boolean posato;
    @NotNull
    String desc_prodotto;
    @NotNull
    String company;
    @NotNull
    String formato;
    @NotNull
    int qta_contestata;
    @NotNull
    String unita_misura;

}
