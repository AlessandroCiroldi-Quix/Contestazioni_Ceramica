package DTO;

import lombok.Data;

@Data
public class cont_art_italcerDTO {


    private Long id_cont;

    private String codArticolo;
    private String tono;
    private boolean posato;
    private String descProdotto;
    private String company;
    private String formato;
    private int qtaContestata;
    private String unitaMisura;
}
