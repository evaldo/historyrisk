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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         
        int idCatgRisco = Integer.parseInt(request.getParameter("idCatgRisco"));
        String dsCatgRisco = request.getParameter("dsCatgRisco");
        
             
        CategoriaRisco categoriaRisco = new CategoriaRisco();
        categoriaRisco.setIdCategoriaRisco(idCatgRisco);
        categoriaRisco.setDsCategoriaRisco(dsCatgRisco);
        
        CategoriaRiscoDAO sed = DAOFactory.createCategoraiRiscoDAO();
        sed.inserir(categoriaRisco);
        
        request.getRequestDispatcher("JnlCnsltCategoriaRisco.jsp");
    }


}
