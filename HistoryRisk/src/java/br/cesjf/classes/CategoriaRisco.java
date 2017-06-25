package br.cesjf.classes;

import java.util.Date;

public class CategoriaRisco {

    private int idCategoriaRisco;
    private String dsCategoriaRisco;
    private Usuario nuMatrIncs;
    private Date dtIncs;
    private Usuario nuMatrAltr;
    private Date dtAltr;
    

    public CategoriaRisco() {
    }

    public int getIdCategoriaRisco() {
        return idCategoriaRisco;
    }

    public void setIdCategoriaRisco(int idCategoriaRisco) {
        this.idCategoriaRisco = idCategoriaRisco;
    }

    public String getDsCategoriaRisco() {
        return dsCategoriaRisco;
    }

    public void setDsCategoriaRisco(String dsCategoriaRisco) {
        this.dsCategoriaRisco = dsCategoriaRisco;
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
