package br.cesjf.classes;

import java.util.Date;

public class FaixaProbabilidade {

    private int idFaixaProb;
    private String dsFaixaProb;
    private int nuLmteInfr;
    private int nuLmteSupr;
    private Usuario nuMatrIncs;
    private Date dtIncs;
    private Usuario nuMatrAltr;
    private Date dtAltr;

    public FaixaProbabilidade() {
    }

    public int getIdFaixaProb() {
        return idFaixaProb;
    }

    public void setIdFaixaProb(int idFaixaProb) {
        this.idFaixaProb = idFaixaProb;
    }

    public String getDsFaixaProb() {
        return dsFaixaProb;
    }

    public void setDsFaixaProb(String dsFaixaProb) {
        this.dsFaixaProb = dsFaixaProb;
    }

    public int getNuLmteInfr() {
        return nuLmteInfr;
    }

    public void setNuLmteInfr(int nuLmteInfr) {
        this.nuLmteInfr = nuLmteInfr;
    }

    public int getNuLmteSupr() {
        return nuLmteSupr;
    }

    public void setNuLmteSupr(int nuLmteSupr) {
        this.nuLmteSupr = nuLmteSupr;
    }

    public Usuario getNuMatrIncs() {
        return nuMatrIncs;
    }

    public void setNuMatrIncs(Usuario nuMatrIncs) {
        this.nuMatrIncs = nuMatrIncs;
    }

    public Date getDtIncs() {
        return dtIncs;
    }

    public void setDtIncs(Date dtIncs) {
        this.dtIncs = dtIncs;
    }

    public Usuario getNuMatrAltr() {
        return nuMatrAltr;
    }

    public void setNuMatrAltr(Usuario nuMatrAltr) {
        this.nuMatrAltr = nuMatrAltr;
    }

    public Date getDtAltr() {
        return dtAltr;
    }

    public void setDtAltr(Date dtAltr) {
        this.dtAltr = dtAltr;
    }
    
    

}
