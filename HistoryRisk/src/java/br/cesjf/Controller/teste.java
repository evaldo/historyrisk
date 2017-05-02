package br.cesjf.Controller;

import br.cesjf.classes.FaixaProbabilidade;
import br.cesjf.classes.Projeto;
import br.cesjf.classes.Risco;
import br.cesjf.classes.SetorEmpresa;
import br.cesjf.dao.FaixaProbabilidadeDAO;
import br.cesjf.dao.ProjetoDAO;
import br.cesjf.dao.RiscoDAO;
import br.cesjf.dao.SetorEmpresaDAO;
import br.cesjf.util.ConnectionFactory;
import br.cesjf.util.DAOFactory;
import java.util.List;


public class teste {

 
    public static void main(String[] args) {
        ConnectionFactory.getConnection();
        
        //SetorEmpresa setorEmpresa = new SetorEmpresa();
        //setorEmpresa.setIdSetorEmpr(2);
        //setorEmpresa.setNmSetorEmpr("RECURSOS HUMANOS");
        
        //SetorEmpresaDAO sed = DAOFactory.createSetorEmpresaDAO();
        //sed.inserir(setorEmpresa);
        
//        FaixaProbabilidadeDAO fp = DAOFactory.createFaixaProbabilidadeDAO();
//        FaixaProbabilidade faixaProbabilidade = fp.buscar(1);
//            System.out.println("------------------------------------------");
//            System.out.println("ID: " + faixaProbabilidade.getIdFaixaProb());
//            System.out.println("Desc: " + faixaProbabilidade.getDsFaixaProb());
//            System.out.println("Inf: " + faixaProbabilidade.getNuLmteInfr());
//            System.out.println("Sup: " + faixaProbabilidade.getNuLmteSupr());
//            System.out.println("------------------------------------------");
        
        RiscoDAO rsc = DAOFactory.createRiscoDAO();
        List<Risco> riscos = rsc.listar();
        for (Risco risco : riscos) {
            
            System.out.println("------------------------------------------");
            System.out.println("ID: " + risco.getIdHrskRisco());
            System.out.println("Faixa Probabilidade: " + risco.getFaixaProbabilidade().getDsFaixaProb());
            System.out.println("Categoria do Risco: " + risco.getCategoriaRisco().getDsCategoriaRisco());
            System.out.println("Nivel Impacto: " + risco.getNivelImpacto().getDsNivelIpcto());
            System.out.println("Projeto: " + risco.getProjeto().getDsPrjt());
            System.out.println("Valor Negativo: " + risco.getVlCustoEsprdRiscoNgtv());
            System.out.println("Descricao: " + risco.getDsRisco());
            System.out.println("Custo Estimado: " + risco.getVlCustoEstmdRisco());
            System.out.println("Valor Esperado Positivo: " + risco.getVlCustoEsprdRiscoPstv());
            System.out.println("Data Inc: " + risco.getDtlncsRgstRisco());
            System.out.println("Data Alt: " + risco.getDtAltrRgstRisco());
            System.out.println("------------------------------------------");
       }
        
    }
    
}
