package br.cesjf.classes;

import java.util.Date;

public class SubCategoriaRisco {

    private int idSubCatgRisco; //ID_SUBCATG_RISCO
    private CategoriaRisco idCategoriaRisco; //ID_CATG_RISCO
    private String dsSubCatgRisco; //DS_SUBCATG_RISCO
    private Usuario nuMatrIncs; //NU_MATR_INCS
    private Date dtIncs; //DT_INCS
    private Usuario nuMatrAltr; //NU_MATR_ALTR
    private Date dtAltr; //DT_ALTR

    public SubCategoriaRisco() {
    }

    public int getIdSubCatgRisco() {
        return idSubCatgRisco;
    }

    public void setIdSubCatgRisco(int idSubCatgRisco) {
        this.idSubCatgRisco = idSubCatgRisco;
    }

    public CategoriaRisco getIdCategoriaRisco() {
        return idCategoriaRisco;
    }

    public void setIdCategoriaRisco(CategoriaRisco idCategoriaRisco) {
        this.idCategoriaRisco = idCategoriaRisco;
    }

    public String getDsSubCatgRisco() {
        return dsSubCatgRisco;
    }

    public void setDsSubCatgRisco(String dsSubCatgRisco) {
        this.dsSubCatgRisco = dsSubCatgRisco;
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
