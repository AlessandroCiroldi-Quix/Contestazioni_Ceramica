package DTO;

import lombok.Data;

import java.sql.Timestamp;


@SuppressWarnings("unused")
@Data
public class eliosFiltroDTO {
    private int id;
    private Timestamp data_creazione;
    private Timestamp data_ultima_mod;
    private String cod_articolo;
    private String rs_cliente;
    private String stato;
    private String reparto;
    private String formato;
    private String utente_creazione;

}
