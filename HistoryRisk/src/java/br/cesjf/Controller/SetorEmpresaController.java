package br.cesjf.Controller;

import br.cesjf.classes.SetorEmpresa;
import br.cesjf.dao.SetorEmpresaDAO;
import br.cesjf.util.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SetorEmpresaController", urlPatterns = {"/SetorEmpresaController"})
public class SetorEmpresaController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String opcao = request.getParameter("opcao");
        int idSetorEmpr = Integer.parseInt(request.getParameter("idSetorEmpr"));
        String nmSetorEmpr = request.getParameter("nmSetorEmpr");

        if (opcao.equals("incluir")) {
            
            SetorEmpresa setorEmpresa = new SetorEmpresa();
            setorEmpresa.setIdSetorEmpr(idSetorEmpr);
            setorEmpresa.setNmSetorEmpr(nmSetorEmpr);

            SetorEmpresaDAO sed = DAOFactory.createSetorEmpresaDAO();
            sed.inserir(setorEmpresa);

            request.getRequestDispatcher("JnlCnsltSetorEmpresa.jsp").forward(request, response);
        }

    }

}
