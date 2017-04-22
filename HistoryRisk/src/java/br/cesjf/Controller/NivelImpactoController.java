package br.cesjf.Controller;

import br.cesjf.classes.NivelImpacto;
import br.cesjf.dao.NivelImpactoDAO;
import br.cesjf.util.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NivelImpactoController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
               
        
        int idNivelIpcto = Integer.parseInt(request.getParameter("idNivelIpcto"));
        String nmNivelIpcto = request.getParameter("nmNivelIpcto");
        String dsNivelIpcto = request.getParameter("dsNivelIpcto");
        int icNivelIpcto = Integer.parseInt(request.getParameter("icNivelIpcto"));
       
        
        NivelImpacto nivelImpacto = new NivelImpacto();
        nivelImpacto.setIdNivelIpcto(idNivelIpcto);
        nivelImpacto.setNmNivelIpcto(nmNivelIpcto);
        nivelImpacto.setDsNivelIpcto(dsNivelIpcto);
        nivelImpacto.setIcNivelIpcto(icNivelIpcto);
        
        
        NivelImpactoDAO sed = DAOFactory.createNivelImpactoDAO();
        sed.inserir(nivelImpacto);
        
        request.getRequestDispatcher("JnlCnsltNivelImpacto.jsp").forward(request,response);
    }

 
}
