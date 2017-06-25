package br.cesjf.Ajax;

import br.cesjf.classes.Risco;
import br.cesjf.dao.RiscoDAO;
import br.cesjf.util.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RiscoByProjectSucess", urlPatterns = {"/RiscoByProjectSucess"})
public class RiscoByProjectSucess extends HttpServlet {

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

        int projeto = Integer.parseInt(request.getParameter("projeto"));

        RiscoDAO se = DAOFactory.createRiscoDAO();
        List<Risco> riscos = se.getByProject(projeto);
        Double vlrTotalMonetarioEsperado = 0.0;
        int i = 1;

        for (Risco r : riscos) {
            Double vlrMonetarioEsperado = r.getNuPerctProbRisco() * r.getVlCustoEsprdRiscoPstv();

            String SaidaTexto = " <tr>\n"
                    + "                                    <td>" + r.getDsRisco() + "</td>\n"
                    + "                                    <td>\n"
                    + "                                        <div>\n"
                    + "                                            <input type=\"number\" class=\"form-control\" name=\"nuPerctProbRisco" + i + "\" value=" + r.getNuPerctProbRisco() + ">\n"
                    + "                                        </div>\n"
                    + "                                    <td>\n"
                    + "                                        <div>\n"
                    + "                                            <input type=\"number\" class=\"form-control\" name=\"descImpactoCasoSucesso\">\n"
                    + "                                        </div>\n"
                    + "                                    </td>\n"
                    + "                                    <td>\n"
                    + "                                        <div>\n"
                    + "                                            <input type=\"text\" class=\"form-control\" name=\"vlCustoEsprdRiscoPstv" + i + "\" value=" + r.getVlCustoEsprdRiscoPstv() + ">\n"
                    + "                                        </div>\n"
                    + "                                    </td>\n"
                    + "                                    <td>\n"
                    + "                                        <div>\n"
                    + "                                            <input type=\"number\" class=\"form-control\" name=\"vlrMonetarioEsperado" + i + "\" value=" + vlrMonetarioEsperado + " readonly>\n"
                    + "                                        </div>\n"
                    + "                                    </td>\n"
                    + "                                </tr>";
            out.print(SaidaTexto);
            i++;
            vlrTotalMonetarioEsperado += vlrMonetarioEsperado;
        }

        out.print("                                    <td colspan=\"4\">\n");
        out.print("                                    <b>Valor Total:</b>");
        out.print("                                    </td>\n");
        out.print("                                    <td>\n");
        out.print("                                    <input type=\"text\" class=\"form-control\" name=\"vlrTotalMonetarioEsperadoSucess\" id=\"vlrTotalMonetarioEsperadoSucess\" value=" + vlrTotalMonetarioEsperado + " onchange=\"somaValores()\" readonly>\n");
        out.print("                                    </td>\n");

    }

}
