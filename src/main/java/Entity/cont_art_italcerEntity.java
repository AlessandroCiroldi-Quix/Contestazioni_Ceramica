package Entity;

import enumerators.Company;
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
    private int id_cont;
    private String cod_articolo;
    @NotNull
    private String tono;
    @NotNull
    private boolean posato;
    @NotNull
    private String desc_prodotto;
    @NotNull
    private Company company;
    @NotNull
    private String formato;
    @NotNull
    private int qta_contestata;
    @NotNull
    private String unita_misura;

}
