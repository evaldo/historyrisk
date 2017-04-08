package br.cesjf.Controller;

import br.cesjf.classes.Projeto;
import br.cesjf.classes.SetorEmpresa;
import br.cesjf.dao.ProjetoDAO;
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
        
        ProjetoDAO prjt = DAOFactory.createProjetoDAO();
         List<Projeto> projetos = prjt.listar();
        for (Projeto projeto : projetos) {
            System.out.println("------------------------------------------");
            System.out.println("ID: " + projeto.getIdHrskprjt());
            System.out.println("Nome do setor da empresa: " + projeto.getSetorEmpresa().getNmSetorEmpr());
            System.out.println("Descrição do Projeto: " + projeto.getDsPrjt());
            System.out.println("Data do Projeto: " + projeto.getDtRgstPrjt());
            System.out.println("------------------------------------------");
       }
        
    }
    
}
