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
import org.apache.jasper.tagplugins.jstl.core.ForEach;

@WebServlet(name = "RiscoByProjectFailure", urlPatterns = {"/RiscoByProjectFailure"})
public class RiscoByProjectFailure extends HttpServlet {

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
        int i=1;

        for (Risco r : riscos) {
            Double vlrMonetarioEsperado = r.getNuPerctProbRisco() * r.getVlCustoEsprdRiscoNgtv();
            String SaidaTexto = " <tr>\n"
                    + "                                    <td>" + r.getDsRisco() + "</td>\n"
                    + "                                    <td>"
                    + "                                       <input type=\"number\" class=\"form-control\" id =\"nuPerctProbRisco"+i+"\" name=\"nuPerctProbRisco"+i+"\" value="+r.getNuPerctProbRisco()+" onblur=\"multiplicarValores('nuPerctProbRisco"+i+"', 'vlCustoEsprdRiscoNgtv"+i+"', 'vlrMonetarioEsperado"+i+"')\" />\n"     
                    + "                                    </td>\n"
                    + "                                    <td>\n"
                    + "                                        <div>\n"
                    + "                                            <input type=\"text\" class=\"form-control\" name=\"descImpactoCasoFalha"+i+"\" />\n"
                    + "                                        </div>\n"
                    + "                                    </td>\n"
                    + "                                    <td>\n"
                    + "                                        <div>\n"
                    + "                                            <input type=\"number\" class=\"form-control\" id=\"vlCustoEsprdRiscoNgtv"+i+"\" name=\"vlCustoEsprdRiscoNgtv"+i+"\" value="+r.getVlCustoEsprdRiscoNgtv()+" onblur=\"multiplicarValores('nuPerctProbRisco"+i+"', 'vlCustoEsprdRiscoNgtv"+i+"', 'vlrMonetarioEsperado"+i+"')\" />\n"
                    + "                                        </div>\n"
                    + "                                    </td>\n"
                    + "                                    <td>\n"
                    + "                                        <div>\n"
                    + "                                            <input type=\"text\" class=\"form-control\" id=\"vlrMonetarioEsperado"+i+"\" name=\"vlrMonetarioEsperado"+i+"\" value=" + vlrMonetarioEsperado + " readonly />\n"
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
        out.print("                                    <input type=\"text\" class=\"form-control\" name=\"vlrTotalMonetarioEsperadoFalha\" id=\"vlrTotalMonetarioEsperadoFalha\" value=" + vlrTotalMonetarioEsperado + " onchange=\"somaValores()\" readonly/>\n");
        out.print("                                    </td>\n");
    }
}
