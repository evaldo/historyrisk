package br.cesjf.classes;

import java.util.Date;

public class Risco {
    
    private int idHrskRisco;
    private FaixaProbabilidade faixaProbabilidade;
    private CategoriaRisco categoriaRisco;
    private NivelImpacto nivelImpacto;
    private Projeto projeto;
    private Double vlCustoEsprdRiscoNgtv;
    private String dsRisco;
    private Double vlCustoEstmdRisco;
    private Double vlCustoEsprdRiscoPstv;
    private Usuario nuMatrIncs;
    private Date dtIncs;
    private Usuario nuMatrAltr;
    private Date dtAltr;
    private Double nuPerctProbRisco; //NU_PERCT_PROB_RISCO
    private String icRiscoOcrrdPrjt; //IC_RISCO_OCRRD_PRJT
    private String obRiscoOcrrdPrjt; //OB_RISCO_OCRRD_PRJT
    private SubCategoriaRisco subCategoriaRisco; // //ID_SUBCATG_RISCO

    public Risco() {
    }

    public int getIdHrskRisco() {
        return idHrskRisco;
    }

    public void setIdHrskRisco(int idHrskRisco) {
        this.idHrskRisco = idHrskRisco;
    }

    public FaixaProbabilidade getFaixaProbabilidade() {
        return faixaProbabilidade;
    }

    public void setFaixaProbabilidade(FaixaProbabilidade faixaProbabilidade) {
        this.faixaProbabilidade = faixaProbabilidade;
    }

    public CategoriaRisco getCategoriaRisco() {
        return categoriaRisco;
    }

    public void setCategoriaRisco(CategoriaRisco categoriaRisco) {
        this.categoriaRisco = categoriaRisco;
    }

    public NivelImpacto getNivelImpacto() {
        return nivelImpacto;
    }

    public void setNivelImpacto(NivelImpacto nivelImpacto) {
        this.nivelImpacto = nivelImpacto;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Double getVlCustoEsprdRiscoNgtv() {
        return vlCustoEsprdRiscoNgtv;
    }

    public void setVlCustoEsprdRiscoNgtv(Double vlCustoEsprdRiscoNgtv) {
        this.vlCustoEsprdRiscoNgtv = vlCustoEsprdRiscoNgtv;
    }

    public String getDsRisco() {
        return dsRisco;
    }

    public void setDsRisco(String dsRisco) {
        this.dsRisco = dsRisco;
    }

    public Double getVlCustoEstmdRisco() {
        return vlCustoEstmdRisco;
    }

    public void setVlCustoEstmdRisco(Double vlCustoEstmdRisco) {
        this.vlCustoEstmdRisco = vlCustoEstmdRisco;
    }

    public Double getVlCustoEsprdRiscoPstv() {
        return vlCustoEsprdRiscoPstv;
    }

    public void setVlCustoEsprdRiscoPstv(Double vlCustoEsprdRiscoPstv) {
        this.vlCustoEsprdRiscoPstv = vlCustoEsprdRiscoPstv;
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

    public Double getNuPerctProbRisco() {
        return nuPerctProbRisco;
    }

    public void setNuPerctProbRisco(Double nuPerctProbRisco) {
        this.nuPerctProbRisco = nuPerctProbRisco;
    }

    public String getIcRiscoOcrrdPrjt() {
        return icRiscoOcrrdPrjt;
    }

    public void setIcRiscoOcrrdPrjt(String icRiscoOcrrdPrjt) {
        this.icRiscoOcrrdPrjt = icRiscoOcrrdPrjt;
    }

    public String getObRiscoOcrrdPrjt() {
        return obRiscoOcrrdPrjt;
    }

    public void setObRiscoOcrrdPrjt(String obRiscoOcrrdPrjt) {
        this.obRiscoOcrrdPrjt = obRiscoOcrrdPrjt;
    }

    public SubCategoriaRisco getSubCategoriaRisco() {
        return subCategoriaRisco;
    }

    public void setSubCategoriaRisco(SubCategoriaRisco subCategoriaRisco) {
        this.subCategoriaRisco = subCategoriaRisco;
    }
    
    
    
    
    
    
    
}
