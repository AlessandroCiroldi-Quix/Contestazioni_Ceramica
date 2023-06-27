package DTO;

import enumerators.Company;
import lombok.Data;

//
@SuppressWarnings("unused")
@Data
public class cont_art_italcerDTO {


    private Long id_cont;

    private String cod_articolo;
    private String tono;
    private boolean posato;
    private String descProdotto;
    private Company company;
    private String formato;
    private int qtaContestata;
    private String unita_misura;
}
