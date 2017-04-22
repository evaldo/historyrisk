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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String opcao = request.getParameter("opcao");
        int idNivelIpcto = Integer.parseInt(request.getParameter("idNivelIpcto"));
        
        if (opcao.equals("excluir")){
            
            NivelImpactoDAO nvlimp = DAOFactory.createNivelImpactoDAO();
            nvlimp.remover(idNivelIpcto);

            request.getRequestDispatcher("JnlCnsltFaixaProbabilidade.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
               
        String opcao = request.getParameter("opcao");
        int idNivelIpcto = Integer.parseInt(request.getParameter("idNivelIpcto"));
        String nmNivelIpcto = request.getParameter("nmNivelIpcto");
        String dsNivelIpcto = request.getParameter("dsNivelIpcto");
        int icNivelIpcto = Integer.parseInt(request.getParameter("icNivelIpcto"));
       
        
        NivelImpacto nivelImpacto = new NivelImpacto();
        nivelImpacto.setIdNivelIpcto(idNivelIpcto);
        nivelImpacto.setNmNivelIpcto(nmNivelIpcto);
        nivelImpacto.setDsNivelIpcto(dsNivelIpcto);
        nivelImpacto.setIcNivelIpcto(icNivelIpcto);
        
        if(opcao.equals("incluir")){
            
            NivelImpactoDAO sed = DAOFactory.createNivelImpactoDAO();
            sed.inserir(nivelImpacto);  
        }
        
        if(opcao.equals("alterar")){
            
            NivelImpactoDAO sed = DAOFactory.createNivelImpactoDAO();
            sed.editar(nivelImpacto);  
        }
        
        

        
        request.getRequestDispatcher("JnlCnsltNivelImpacto.jsp").forward(request,response);
    }

 
}
