package Entity;

import io.smallrye.common.constraint.NotNull;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "contestazioni_fab")
@Data
public class contestazioni_fabEntity {

    @NotNull
    private int id;
    @NotNull
    private String cod_cliente; //NOT NULL
    @NotNull
    private String rs_cliente; //NOT NULL
    @NotNull
    private String cod_articolo; //NOT NULL
    @NotNull
    private String tono; //NOT NULL
    @NotNull
    private String num_fattura; //NULL
    @NotNull
    private Date data_fattura; //NULL
    @NotNull
    private String descrizione; //NOT NULL
    @NotNull
    private int qta_contestata; //NOT NULL
    @NotNull
    private String unita_misura; //NOT NULL
    @NotNull
    private int posato; //NOT NULL
    @NotNull
    private String stato;//NOT NULL
    @NotNull
    private String utente_creazione; //NOT NULL
    @NotNull
    private Timestamp data_creazione;  //DEFAULT CURRENT_TIMESTAMP,
    @NotNull
    private String utente_ultima_mod; //NULL
    @NotNull
    private Timestamp data_ultima_mod; //DEFAULT '0000-00-00 00:00:00',
    @NotNull
    private String desc_prodotto;
    @NotNull
    private String uid_files; //NULL
    @NotNull
    private String tipology; //NULL
    @NotNull
    private String motivazione;
    @NotNull
    private String company; //NOT NULL
    @NotNull
    private String num_buono; //NULL
    @NotNull
    private String num_bolla; //NULL
    @NonNull
    private String num_ord_reparto; //NULL
    @NotNull
    private String difettosita; //NULL
    @NotNull
    private int deleted = 0; //DEFAULT '0'

}
