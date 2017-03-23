package br.cesjf.classes;

import java.util.Date;

public class Projeto {

    private int idHrskprjt;
    private SetorEmpresa setorEmpresa;
    private String dsPrjt;
    private Date dtRgstPrjt;

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
    
    
    
}
