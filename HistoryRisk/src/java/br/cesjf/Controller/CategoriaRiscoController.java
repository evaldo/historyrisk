package br.cesjf.Controller;

import br.cesjf.classes.CategoriaRisco;
import br.cesjf.dao.CategoriaRiscoDAO;
import br.cesjf.util.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CategoriaRiscoController extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcao = request.getParameter("opcao");
        int idCategoriaRisco = Integer.parseInt(request.getParameter("idCategoriaRisco"));
        String dsCategoriaRisco = request.getParameter("dsCategoriaRisco");
        
        if (opcao.equals("excluir")){
            
            CategoriaRisco categoriaRisco = new CategoriaRisco();
            categoriaRisco.setIdCategoriaRisco(idCategoriaRisco);
            categoriaRisco.setDsCategoriaRisco(dsCategoriaRisco);
            
            CategoriaRiscoDAO ctgr = DAOFactory.createCategoraiRiscoDAO();
            ctgr.remover(idCategoriaRisco);

            request.getRequestDispatcher("JnlCnsltCategoriaRisco.jsp").forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcao = request.getParameter("opcao");
        int idCatgRisco = Integer.parseInt(request.getParameter("idCatgRisco"));
        String dsCatgRisco = request.getParameter("dsCatgRisco");
        
             
        CategoriaRisco categoriaRisco = new CategoriaRisco();
        categoriaRisco.setIdCategoriaRisco(idCatgRisco);
        categoriaRisco.setDsCategoriaRisco(dsCatgRisco);
        
        if(opcao.equals("incluir")){
            
            CategoriaRiscoDAO sed = DAOFactory.createCategoraiRiscoDAO();
            sed.inserir(categoriaRisco);
            request.getRequestDispatcher("JnlCnsltCategoriaRisco.jsp").forward(request,response);
        
        }
        if(opcao.equals("alterar")){
            
            CategoriaRiscoDAO sed = DAOFactory.createCategoraiRiscoDAO();
            sed.editar(categoriaRisco);
            request.getRequestDispatcher("JnlCnsltCategoriaRisco.jsp").forward(request,response);
            
        }

    }

}
