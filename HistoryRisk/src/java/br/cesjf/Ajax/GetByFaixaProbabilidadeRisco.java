package br.cesjf.Ajax;

import br.cesjf.classes.FaixaProbabilidade;
import br.cesjf.dao.FaixaProbabilidadeDAO;
import br.cesjf.util.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GetByFaixaProbabilidadeRisco", urlPatterns = {"/GetByFaixaProbabilidadeRisco"})
public class GetByFaixaProbabilidadeRisco extends HttpServlet {

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

        int nuPerctProbRisco = Integer.parseInt(request.getParameter("nuPerctProbRisco"));

        FaixaProbabilidadeDAO se = DAOFactory.createFaixaProbabilidadeDAO();
        List<FaixaProbabilidade> faixasProbabilidade = se.getByFaixaProbabilidadeRisco(nuPerctProbRisco);

        for (FaixaProbabilidade r : faixasProbabilidade) {

            //String SaidaTexto = "<option value="++">" +  + "</option>\n";
            String SaidaTexto = "<option value=\"" + r.getIdFaixaProb() + "\">" + r.getDsFaixaProb() + "</option>\n";
            out.print(SaidaTexto);

        }

    }

}
