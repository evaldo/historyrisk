package Classes;

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
    private Date dtlncsRgstRisco;
    private Date dtAltrRgstRisco;

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

    public Date getDtlncsRgstRisco() {
        return dtlncsRgstRisco;
    }

    public void setDtlncsRgstRisco(Date dtlncsRgstRisco) {
        this.dtlncsRgstRisco = dtlncsRgstRisco;
    }

    public Date getDtAltrRgstRisco() {
        return dtAltrRgstRisco;
    }

    public void setDtAltrRgstRisco(Date dtAltrRgstRisco) {
        this.dtAltrRgstRisco = dtAltrRgstRisco;
    }
    
    
    
    
}
