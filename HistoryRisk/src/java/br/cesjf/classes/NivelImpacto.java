package br.cesjf.classes;

import java.util.Date;

public class NivelImpacto {
    
    private int idNivelIpcto;
    private String nmNivelIpcto;
    private String dsNivelIpcto;
    private String icNivelIpcto;
    private Double vlAsscNivelIpcto;
    private Usuario nuMatrIncs;
    private Date dtIncs;
    private Usuario nuMatrAltr;
    private Date dtAltr;


    public NivelImpacto() {
    }

    public int getIdNivelIpcto() {
        return idNivelIpcto;
    }

    public void setIdNivelIpcto(int idNivelIpcto) {
        this.idNivelIpcto = idNivelIpcto;
    }

    public String getNmNivelIpcto() {
        return nmNivelIpcto;
    }

    public void setNmNivelIpcto(String nmNivelIpcto) {
        this.nmNivelIpcto = nmNivelIpcto;
    }

    public String getDsNivelIpcto() {
        return dsNivelIpcto;
    }

    public void setDsNivelIpcto(String dsNivelIpcto) {
        this.dsNivelIpcto = dsNivelIpcto;
    }

    public String getIcNivelIpcto() {
        return icNivelIpcto;
    }

    public void setIcNivelIpcto(String icNivelIpcto) {
        this.icNivelIpcto = icNivelIpcto;
    }

    public Double getVlAsscNivelIpcto() {
        return vlAsscNivelIpcto;
    }

    public void setVlAsscNivelIpcto(Double vlAsscNivelIpcto) {
        this.vlAsscNivelIpcto = vlAsscNivelIpcto;
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
