package br.cesjf.classes;

import java.util.Date;

public class Projeto {

    private int idHrskprjt;
    private SetorEmpresa setorEmpresa;
    private String dsPrjt;
    private Date dtRgstPrjt;
    private Usuario nuMatrIncs;
    private Date dtIncs;
    private Usuario nuMatrAltr;
    private Date dtAltr;


    public Projeto() {
    }

    public int getIdHrskprjt() {
        return idHrskprjt;
    }

    public void setIdHrskprjt(int idHrskprjt) {
        this.idHrskprjt = idHrskprjt;
    }

    public SetorEmpresa getSetorEmpresa() {
        return setorEmpresa;
    }

    public void setSetorEmpresa(SetorEmpresa setorEmpresa) {
        this.setorEmpresa = setorEmpresa;
    }

    public String getDsPrjt() {
        return dsPrjt;
    }

    public void setDsPrjt(String dsPrjt) {
        this.dsPrjt = dsPrjt;
    }

    public Date getDtRgstPrjt() {
        return dtRgstPrjt;
    }

    public void setDtRgstPrjt(Date dtRgstPrjt) {
        this.dtRgstPrjt = dtRgstPrjt;
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
