package Entity;

import lombok.Data;
import lombok.NonNull;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class contestazioni_italcerEntity {
    private int id;
    //@NonNull
    private String cod_cliente; //NOT NULL
    private String rs_cliente; //NOT NULL
    private String cod_articolo; //NOT NULL
    private String tono; //NOT NULL
    private String num_fattura; //NULL
    private Date data_fattura; //NULL
    private String descrizione; //NOT NULL
    private int qta_contestata; //NOT NULL
    private String unita_misura; //NOT NULL
    private int posato; //NOT NULL
    private String stato;//NOT NULL
    private String utente_creazione; //NOT NULL
    private Timestamp data_creazione;  //DEFAULT CURRENT_TIMESTAMP,
    private String utente_ultima_mod; //NULL
    private Timestamp data_ultima_mod; //DEFAULT '0000-00-00 00:00:00',
    private String desc_prodotto;
    private String uid_files; //NULL
    private String tipology; //NULL
    private String motivazione;
    private String company; //NOT NULL
    private String num_buono; //NULL
    private String num_bolla; //NULL
    private String num_ord_reparto; //NULL
    private String difettosita; //NULL
    private int deleted; //DEFAULT '0'

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
