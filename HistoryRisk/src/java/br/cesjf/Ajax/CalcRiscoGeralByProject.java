package br.cesjf.Ajax;

import br.cesjf.classes.NivelImpacto;
import br.cesjf.classes.Risco;
import br.cesjf.dao.NivelImpactoDAO;
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

@WebServlet(name = "CalcRiscoGeralByProject", urlPatterns = {"/CalcRiscoGeralByProject"})
public class CalcRiscoGeralByProject extends HttpServlet {

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
        int i = 1;
        Double probabilidademMaior = 0.0;
        Double somatorioProbabilidadexIncremento = 0.0;
        Double incrementoMaior = 0.0;
        

        for (Risco r : riscos) {
            i++;
            
            somatorioProbabilidadexIncremento += ((r.getNuPerctProbRisco()/100)*r.getNivelImpacto().getVlAsscNivelIpcto());
            
            if(r.getNuPerctProbRisco() > probabilidademMaior ){
                probabilidademMaior = r.getNuPerctProbRisco();
            }
            
            if(r.getNivelImpacto().getVlAsscNivelIpcto() > incrementoMaior ){
                incrementoMaior = r.getNivelImpacto().getVlAsscNivelIpcto(); 
            }     
        }       
        
        Double ResultprobabilidademMaior = probabilidademMaior/100;
        Double var = ResultprobabilidademMaior * incrementoMaior;
        
        Double nxvar = i * var;
        double riscoGeral = (somatorioProbabilidadexIncremento/nxvar) * 100;
        
        
        String saidaDeTexto = "        <table border=\"1\">\n" +
"            <thead>\n" +
"                <tr>\n" +
"                    <th>Indice</th>\n" +
"                    <th>Valor</th>\n" +
"                </tr>\n" +
"            </thead>\n" +
"            <tbody>\n" +
"                <tr>\n" +
"                    <td>Pmaior</td>\n" +
"                    <td>"+ ResultprobabilidademMaior +"</td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td>Imaior</td>\n" +
"                    <td>"+ incrementoMaior +"</td>\n" +
"                </tr>\n" +
"            </tbody>\n" +
"        </table>\n" +
"";
        out.print(saidaDeTexto);
        out.print("O Grau de exposição a ameaças é de:"+ riscoGeral + "%");

    }
}
