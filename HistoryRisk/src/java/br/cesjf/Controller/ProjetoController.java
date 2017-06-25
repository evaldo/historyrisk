package br.cesjf.Controller;

import br.cesjf.classes.Projeto;
import br.cesjf.classes.SetorEmpresa;
import br.cesjf.classes.Usuario;
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
import javax.servlet.http.HttpSession;

public class ProjetoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String opcao = request.getParameter("opcao");
        int idHrskprjt = Integer.parseInt(request.getParameter("idHrskprjt"));

        if (opcao.equals("excluir")) {

            ProjetoDAO prjt = DAOFactory.createProjetoDAO();
            prjt.remover(idHrskprjt);
            request.getRequestDispatcher("JnlCnsltProjeto.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession sessao = request.getSession();

        String opcao = request.getParameter("opcao");

        if (opcao.equals("incluir")) {

            int NumsetorEmpresa = Integer.parseInt(request.getParameter("setorEmpresa"));
            String dsPrjt = request.getParameter("dsPrjt");
            String dataForm = request.getParameter("dtRgstPrjt");

            SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
            Date dtRgstPrjt = null;
            try {
                dtRgstPrjt = formatador.parse(dataForm);
            } catch (ParseException ex) {
                Logger.getLogger(ProjetoController.class.getName()).log(Level.SEVERE, null, ex);
            }

            Usuario usuario = new Usuario();
            String nuMatrIncs = (String) sessao.getAttribute("nuMatrIncs");
            usuario.setNuMatrIncs(nuMatrIncs);

            Projeto projeto = new Projeto();
            SetorEmpresa setorEmpresa = new SetorEmpresa();
            setorEmpresa.setIdSetorEmpr(NumsetorEmpresa);

            projeto.setSetorEmpresa(setorEmpresa);
            projeto.setDsPrjt(dsPrjt);
            projeto.setDtRgstPrjt(dtRgstPrjt);

            projeto.setNuMatrIncs(usuario);
            projeto.setDtIncs(new Date());

            ProjetoDAO prjt = DAOFactory.createProjetoDAO();
            prjt.inserir(projeto);
            request.getRequestDispatcher("JnlCnsltProjeto.jsp").forward(request, response);
        }

        if (opcao.equals("alterar")) {

            int NumsetorEmpresa = Integer.parseInt(request.getParameter("setorEmpresa"));
            String dsPrjt = request.getParameter("dsPrjt");
            String dataForm = request.getParameter("dtRgstPrjt");

            SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
            Date dtRgstPrjt = null;
            try {
                dtRgstPrjt = formatador.parse(dataForm);
            } catch (ParseException ex) {
                Logger.getLogger(ProjetoController.class.getName()).log(Level.SEVERE, null, ex);
            }

            Usuario usuario = new Usuario();
            String nuMatrIncs = (String) sessao.getAttribute("nuMatrIncs");
            usuario.setNuMatrIncs(nuMatrIncs);

            Projeto projeto = new Projeto();
            SetorEmpresa setorEmpresa = new SetorEmpresa();
            setorEmpresa.setIdSetorEmpr(NumsetorEmpresa);

            projeto.setSetorEmpresa(setorEmpresa);
            projeto.setDsPrjt(dsPrjt);
            projeto.setDtRgstPrjt(dtRgstPrjt);

            int idHrskPrjt = Integer.parseInt(request.getParameter("idHrskPrjt"));
            projeto.setIdHrskprjt(idHrskPrjt);

            projeto.setNuMatrAltr(usuario);
            projeto.setDtAltr(new Date());

            ProjetoDAO prjt = DAOFactory.createProjetoDAO();
            prjt.editar(projeto);
            request.getRequestDispatcher("JnlCnsltProjeto.jsp").forward(request, response);
        }

        if (opcao.equals("pesquisar")) {

            String cmpPesquisa = request.getParameter("cmpPesquisa");

            if (cmpPesquisa.equals("")) {
                request.getRequestDispatcher("JnlCnsltProjeto.jsp").forward(request, response);
            } else {
                ProjetoDAO prjt = DAOFactory.createProjetoDAO();
                prjt.pesquisar(cmpPesquisa);
                request.getRequestDispatcher("JnlPesqProjeto.jsp").forward(request, response);

            }
        }

    }

}
