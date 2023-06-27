package Entity;

import enumerators.Company;
import enumerators.Stato;
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
    private String codCliente;
    @NotNull
    private String rs_cliente; //NOT NULL
    @NotNull
    private String cod_articolo; //NOT NULL
    @NotNull
    private String tono; //NOT NULL
    private String num_fattura; //NULL
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
    private Stato stato;//NOT NULL
    @NotNull
    private String utente_creazione; //NOT NULL
    @NotNull
    private Timestamp data_creazione;  //DEFAULT CURRENT_TIMESTAMP,
    private String utente_ultima_mod; //NULL
    @NotNull
    private Timestamp data_ultima_mod; //DEFAULT '0000-00-00 00:00:00',
    @NotNull
    private String desc_prodotto;
    private String uid_files; //NULL
    private String tipology; //NULL
    @NotNull
    private String motivazione;
    @NotNull
    private Company company; //NOT NULL
    private String num_buono; //NULL
    private String num_bolla; //NULL
    private String num_ord_reparto; //NULL
    private String difettosita; //NULL
    @NotNull
    private int deleted = 0; //DEFAULT '0'

}
