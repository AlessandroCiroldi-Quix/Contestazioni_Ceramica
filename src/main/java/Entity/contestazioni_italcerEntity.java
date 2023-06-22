package Entity;

import io.smallrye.common.constraint.NotNull;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "contestazioni_italcer")
@Data
public class contestazioni_italcerEntity {


    //! ASSOLUTAMENTE DA RIVEDERE DOMANI!!!
    //? Dovremmo inserire le annotazioni per le foreign Key
    //* Sta cosa dei commenti spacca
    //TODO: Il fatto di inserire una todolist nel codice spacca


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
    private String stato;//NOT NULL
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
    private String company; //NOT NULL
    private String num_buono; //NULL
    private String num_bolla; //NULL
    private String num_ord_reparto; //NULL
    private String difettosita; //NULL
    @NotNull
    private int deleted = 0; //DEFAULT '0'

    /*
    public contestazioni_italcerEntity() {
        this.id = id;
        this.cod_cliente = "";
        this.rs_cliente = "";
        this.cod_articolo = "";
        this.tono = "";
        this.num_fattura = null;
        this.data_fattura = null;
        this.descrizione = "";
        this.qta_contestata = qta_contestata;
        this.unita_misura = "";
        this.posato = posato;
        this.stato = stato;
        this.utente_creazione = utente_creazione;
        Date date = new Date();
        this.data_creazione = new Timestamp(date.getTime());;
        this.utente_ultima_mod = null;
        this.data_ultima_mod = Timestamp.valueOf("0000-00-00 00:00:00");;
        this.desc_prodotto = desc_prodotto;
        this.uid_files = null;
        this.tipology = null;
        this.motivazione = motivazione;
        this.company = company;
        this.num_buono = null;
        this.num_bolla = null;
        this.num_ord_reparto = null;
        this.difettosita = null;
        this.deleted = 0;
    }
     */
}
