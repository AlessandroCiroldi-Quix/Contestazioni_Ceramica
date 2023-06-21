package Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cont_art_italcer")
public class cont_art_italcerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cont;

    private String codArticolo;
    private String tono;
    private boolean posato;
    private String descProdotto;
    private String company;
    private String formato;
    private int qtaContestata;
    private String unitaMisura;


    // Costruttore
    public cont_art_italcerEntity(int idCont, String codArticolo, String tono, boolean posato,
                     String descProdotto, String company, String formato,
                     int qtaContestata, String unitaMisura) {
        this.id_cont = id_cont;
        this.codArticolo = codArticolo;
        this.tono = tono;
        this.posato = posato;
        this.descProdotto = descProdotto;
        this.company = company;
        this.formato = formato;
        this.qtaContestata = qtaContestata;
        this.unitaMisura = unitaMisura;
    }




    // Metodi getter e setter
    public Long getId() {
        return id_cont;
    }
    public void setId(Long id) {
        this.id_cont = id;
    }

    public String getCodArticolo() {
        return codArticolo;
    }

    public void setCodArticolo(String codArticolo) {
        this.codArticolo = codArticolo;
    }

    public String getTono() {
        return tono;
    }

    public void setTono(String tono) {
        this.tono = tono;
    }

    public boolean isPosato() {
        return posato;
    }

    public void setPosato(boolean posato) {
        this.posato = posato;
    }

    public String getDescProdotto() {
        return descProdotto;
    }

    public void setDescProdotto(String descProdotto) {
        this.descProdotto = descProdotto;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public int getQtaContestata() {
        return qtaContestata;
    }

    public void setQtaContestata(int qtaContestata) {
        this.qtaContestata = qtaContestata;
    }

    public String getUnitaMisura() {
        return unitaMisura;
    }

    public void setUnitaMisura(String unitaMisura) {
        this.unitaMisura = unitaMisura;
    }
}
