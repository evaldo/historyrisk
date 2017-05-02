package br.cesjf.Controller;

import br.cesjf.classes.FaixaProbabilidade;
import br.cesjf.dao.FaixaProbabilidadeDAO;
import br.cesjf.util.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FaixaProbabilidadeController extends HttpServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String opcao = request.getParameter("opcao");
        int idFaixaProb = Integer.parseInt(request.getParameter("idFaixaProb"));
        
        if (opcao.equals("excluir")){
            
            FaixaProbabilidadeDAO fxpb = DAOFactory.createFaixaProbabilidadeDAO();
            fxpb.remover(idFaixaProb);

            request.getRequestDispatcher("JnlCnsltFaixaProbabilidade.jsp").forward(request, response);
        }
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String opcao = request.getParameter("opcao");
        int idFaixaProb = Integer.parseInt(request.getParameter("idFaixaProb"));
        String dsFaixaProb = request.getParameter("dsFaixaProb");
        int nuLmteInfr = Integer.parseInt(request.getParameter("nuLmteInfr"));
        int nuLmteSupr = Integer.parseInt(request.getParameter("nuLmteSupr"));
       
        
        FaixaProbabilidade faixaProbabilidade = new FaixaProbabilidade();
        faixaProbabilidade.setIdFaixaProb(idFaixaProb);
        faixaProbabilidade.setDsFaixaProb(dsFaixaProb);
        faixaProbabilidade.setNuLmteInfr(nuLmteInfr);
        faixaProbabilidade.setNuLmteSupr(nuLmteSupr);
        
        if(opcao.equals("incluir")){
            
            FaixaProbabilidadeDAO sed = DAOFactory.createFaixaProbabilidadeDAO();
            sed.inserir(faixaProbabilidade);
            request.getRequestDispatcher("JnlCnsltFaixaProbabilidade.jsp").forward(request,response);
        }
        
        if(opcao.equals("alterar")){
            
            FaixaProbabilidadeDAO sed = DAOFactory.createFaixaProbabilidadeDAO();
            sed.editar(faixaProbabilidade);            
            request.getRequestDispatcher("JnlCnsltFaixaProbabilidade.jsp").forward(request,response);
            
        }
        
        

        
    }
 
}