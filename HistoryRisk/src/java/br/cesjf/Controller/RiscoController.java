package br.cesjf.Controller;

import br.cesjf.classes.CategoriaRisco;
import br.cesjf.classes.FaixaProbabilidade;
import br.cesjf.classes.NivelImpacto;
import br.cesjf.classes.Projeto;
import br.cesjf.classes.Risco;
import br.cesjf.dao.RiscoDAO;
import br.cesjf.util.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RiscoController extends HttpServlet {

   
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String opcao = request.getParameter("opcao");
            int idHrskRisco = Integer.parseInt(request.getParameter("idHrskRisco"));
            
            if(opcao.equals("excluir")){
                
            RiscoDAO rsc = DAOFactory.createRiscoDAO();
            rsc.remover(idHrskRisco);
            request.getRequestDispatcher("JnlCnsltRisco.jsp").forward(request, response);
                
            }
       
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String opcao = request.getParameter("opcao");
            int idHrskRisco = Integer.parseInt(request.getParameter("idHrskRisco"));
            int idFaixaProbabilidade = Integer.parseInt(request.getParameter("faixaProbabilidade"));
            int idCategoriaRisco = Integer.parseInt(request.getParameter("categoriaRisco"));
            int idNivelImpacto = Integer.parseInt(request.getParameter("nivelImpacto"));
            int idProjeto = Integer.parseInt(request.getParameter("projeto"));
            Double vlCustoEsprdRiscoNgtv = Double.parseDouble(request.getParameter("vlCustoEsprdRiscoNgtv"));
            String dsRisco = request.getParameter("dsRisco");
            Double vlCustoEstmdRisco = Double.parseDouble(request.getParameter("vlCustoEstmdRisco"));
            Double vlCustoEsprdRiscoPstv = Double.parseDouble(request.getParameter("vlCustoEsprdRiscoPstv"));
            String FormDtIncsRgstRisco = request.getParameter("dtIncsRgstRisco");
            String FormDdtAltrRgstRisco = request.getParameter("dtAltrRgstRisco");
            
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        Date dtIncsRgstRisco = null;
        Date dtAltrRgstRisco = null;
        
        try {
            dtIncsRgstRisco = formatador.parse(FormDtIncsRgstRisco);
            dtAltrRgstRisco = formatador.parse(FormDdtAltrRgstRisco);
            
        } catch (ParseException ex) {
            Logger.getLogger(ProjetoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Risco risco = new Risco();
        
        FaixaProbabilidade faixaProbabilidade = new FaixaProbabilidade();
        faixaProbabilidade.setIdFaixaProb(idFaixaProbabilidade);

        CategoriaRisco categoriaRisco = new CategoriaRisco();
        categoriaRisco.setIdCategoriaRisco(idCategoriaRisco);
        
        NivelImpacto nivelImpacto = new NivelImpacto();
        nivelImpacto.setIdNivelIpcto(idNivelImpacto);
        
        Projeto projeto = new Projeto();
        projeto.setIdHrskprjt(idProjeto);
        
        risco.setIdHrskRisco(idHrskRisco);
        risco.setFaixaProbabilidade(faixaProbabilidade);
        risco.setCategoriaRisco(categoriaRisco);
        risco.setNivelImpacto(nivelImpacto);
        risco.setProjeto(projeto);
        risco.setVlCustoEsprdRiscoNgtv(vlCustoEsprdRiscoNgtv);
        risco.setDsRisco(dsRisco);
        risco.setVlCustoEstmdRisco(vlCustoEstmdRisco);
        risco.setVlCustoEsprdRiscoPstv(vlCustoEsprdRiscoPstv);
        risco.setDtlncsRgstRisco(dtIncsRgstRisco);
        risco.setDtAltrRgstRisco(dtAltrRgstRisco);
        
        if(opcao.equals("incluir")){
            
            RiscoDAO rsc = DAOFactory.createRiscoDAO();
            rsc.inserir(risco);
            request.getRequestDispatcher("JnlCnsltRisco.jsp").forward(request,response);
        }
        
        if(opcao.equals("alterar")){
            
            RiscoDAO rsc = DAOFactory.createRiscoDAO();
            rsc.editar(risco);
            request.getRequestDispatcher("JnlCnsltRisco.jsp").forward(request,response);
        }

    }

}
