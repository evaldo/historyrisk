package br.cesjf.classes;

import java.util.Date;

public class Usuario {
    
    private String nuMatrIncs;
    private String nmIncs;
    private String emailIncs;
    private String usrIncs;
    private String pswIncs;
    private Date dtIncs;

    public Usuario() {
    }

    public String getNuMatrIncs() {
        return nuMatrIncs;
    }

    public void setNuMatrIncs(String nuMatrIncs) {
        this.nuMatrIncs = nuMatrIncs;
    }

    public String getNmIncs() {
        return nmIncs;
    }

    public void setNmIncs(String nmIncs) {
        this.nmIncs = nmIncs;
    }

    public String getEmailIncs() {
        return emailIncs;
    }

    public void setEmailIncs(String emailIncs) {
        this.emailIncs = emailIncs;
    }

    public String getUsrIncs() {
        return usrIncs;
    }

    public void setUsrIncs(String usrIncs) {
        this.usrIncs = usrIncs;
    }

    public String getPswIncs() {
        return pswIncs;
    }

    public void setPswIncs(String pswIncs) {
        this.pswIncs = pswIncs;
    }

    public Date getDtIncs() {
        return dtIncs;
    }

    public void setDtIncs(Date dtIncs) {
        this.dtIncs = dtIncs;
    }
    
}
