package br.cesjf.classes;

import java.util.Date;

public class SetorEmpresa {
    
    private int idSetorEmpr;
    private String nmSetorEmpr;
    private Usuario nuMatrIncs;
    private Date dtIncs;
    private Usuario nuMatrAltr;
    private Date dtAltr;
            
    public SetorEmpresa(){
                
    }

    public int getIdSetorEmpr() {
        return idSetorEmpr;
    }

    public void setIdSetorEmpr(int idSetorEmpr) {
        this.idSetorEmpr = idSetorEmpr;
    }

    public String getNmSetorEmpr() {
        return nmSetorEmpr;
    }

    public void setNmSetorEmpr(String nmSetorEmpr) {
        this.nmSetorEmpr = nmSetorEmpr;
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
