package br.cesjf.Ajax;

import br.cesjf.classes.SubCategoriaRisco;
import br.cesjf.dao.SubCategoriaRiscoDAO;
import br.cesjf.util.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SubCategoriaRiscoByCategoriaRisco", urlPatterns = {"/SubCategoriaRiscoByCategoriaRisco"})
public class SubCategoriaRiscoByCategoriaRisco extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        int categoriaRisco = Integer.parseInt(request.getParameter("categoriaRisco"));

        SubCategoriaRiscoDAO se = DAOFactory.createSubCategoriaRiscoDAO();
        List<SubCategoriaRisco> subCategoriasRisco = se.getByCategoriaRisco(categoriaRisco);

        for (SubCategoriaRisco r : subCategoriasRisco) {

            String SaidaTexto = "<option value=\"" + r.getIdSubCatgRisco() + "\">" + r.getDsSubCatgRisco() + "</option>\n";
            out.print(SaidaTexto);

        }

    }

}
