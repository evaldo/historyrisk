package br.cesjf.Controller;

import br.cesjf.classes.Projeto;
import br.cesjf.classes.SetorEmpresa;
import br.cesjf.dao.JDBCProjetoDAO;
import br.cesjf.dao.JDBCSetorEmpresaDAO;
import br.cesjf.dao.ProjetoDAO;
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


public class ProjetoController extends HttpServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String opcao = request.getParameter("opcao");
        int idHrskprjt = Integer.parseInt(request.getParameter("idHrskprjt"));
        
        if (opcao.equals("excluir")){
            
            ProjetoDAO prjt = DAOFactory.createProjetoDAO();
            prjt.remover(idHrskprjt);
            request.getRequestDispatcher("JnlCnsltProjeto.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String opcao = request.getParameter("opcao");
        int idHrskPrjt = Integer.parseInt(request.getParameter("idHrskPrjt"));
        int NumsetorEmpresa = Integer.parseInt(request.getParameter("setorEmpresa"));
        String dsPrjt = request.getParameter("dsPrjt");
        String dataForm = request.getParameter("dtRgstPrjt");
        
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        Date dtRgstPrjt = null;
        try {
            dtRgstPrjt = formatador.parse(dataForm);
        } catch (ParseException ex) {
            Logger.getLogger(ProjetoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Projeto projeto = new Projeto();
        SetorEmpresa setorEmpresa = new SetorEmpresa();
        setorEmpresa.setIdSetorEmpr(NumsetorEmpresa);
        
        projeto.setIdHrskprjt(idHrskPrjt);
        projeto.setSetorEmpresa(setorEmpresa);
        projeto.setDsPrjt(dsPrjt);
        projeto.setDtRgstPrjt(dtRgstPrjt);
        
        if(opcao.equals("incluir")){
            
            ProjetoDAO prjt = DAOFactory.createProjetoDAO();
            prjt.inserir(projeto);
            request.getRequestDispatcher("JnlCnsltProjeto.jsp").forward(request,response);
        }
        
        if(opcao.equals("alterar")){
            
            ProjetoDAO prjt = DAOFactory.createProjetoDAO();
            prjt.editar(projeto);
            request.getRequestDispatcher("JnlCnsltProjeto.jsp").forward(request,response);
        }
        
    }

}
