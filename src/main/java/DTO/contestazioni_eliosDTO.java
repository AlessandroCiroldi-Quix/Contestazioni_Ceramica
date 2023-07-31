package DTO;

import enumerators.Company;
import enumerators.Stato;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@SuppressWarnings("unused")
@Data
public class contestazioni_eliosDTO {
    private int id;
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
}
