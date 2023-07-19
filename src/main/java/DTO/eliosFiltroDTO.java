package DTO;

import lombok.Data;

import java.util.Date;

@Data
public class eliosFiltroDTO {
    private int id;
    private Date data_creazione;
    private Date data_ultima_mod;
    private String cod_articolo;
    private String rs_cliente;
    private String stato;
    private String reparto;
    private String formato;
    private String utente_creazione;

}
