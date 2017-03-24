package br.cesjf.Controller;

import br.cesjf.classes.SetorEmpresa;
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
        
//        SetorEmpresaDAO se = DAOFactory.createSetorEmpresaDAO();
//        List<SetorEmpresa> setoresEmpresa = se.listar();
//        for (SetorEmpresa setorEmpresa : setoresEmpresa) {
//            System.out.println("------------------------------------------");
//            System.out.println("ID: " + setorEmpresa.getIdSetorEmpr());
//            System.out.println("Nome: " + setorEmpresa.getNmSetorEmpr());
//            System.out.println("------------------------------------------");
//        }
        
    }
    
}
