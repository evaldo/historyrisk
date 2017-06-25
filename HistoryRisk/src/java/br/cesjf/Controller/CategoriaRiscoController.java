package br.cesjf.Controller;

import br.cesjf.classes.CategoriaRisco;
import br.cesjf.classes.Usuario;
import br.cesjf.dao.CategoriaRiscoDAO;
import br.cesjf.util.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CategoriaRiscoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcao = request.getParameter("opcao");
        
        int idCategoriaRisco = Integer.parseInt(request.getParameter("idCategoriaRisco"));

        if (opcao.equals("excluir")) {

            CategoriaRiscoDAO ctgr = DAOFactory.createCategoraiRiscoDAO();
            ctgr.remover(idCategoriaRisco);

            request.getRequestDispatcher("JnlCnsltCategoriaRisco.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession sessao = request.getSession();

        String opcao = request.getParameter("opcao");
        String dsCatgRisco = request.getParameter("dsCatgRisco");

        CategoriaRisco categoriaRisco = new CategoriaRisco();
        categoriaRisco.setDsCategoriaRisco(dsCatgRisco);

        Usuario usuario = new Usuario();
        String nuMatrIncs = (String) sessao.getAttribute("nuMatrIncs");
        usuario.setNuMatrIncs(nuMatrIncs);

        if (opcao.equals("incluir")) {

            categoriaRisco.setNuMatrIncs(usuario);
            categoriaRisco.setDtIncs(new Date());

            CategoriaRiscoDAO sed = DAOFactory.createCategoraiRiscoDAO();
            sed.inserir(categoriaRisco);
            request.getRequestDispatcher("JnlCnsltCategoriaRisco.jsp").forward(request, response);

        }
        if (opcao.equals("alterar")) {

            int idCatgRisco = Integer.parseInt(request.getParameter("idCatgRisco"));
            categoriaRisco.setIdCategoriaRisco(idCatgRisco);

            categoriaRisco.setNuMatrAltr(usuario);
            categoriaRisco.setDtAltr(new Date());

            CategoriaRiscoDAO sed = DAOFactory.createCategoraiRiscoDAO();
            sed.editar(categoriaRisco);
            request.getRequestDispatcher("JnlCnsltCategoriaRisco.jsp").forward(request, response);
        }

        if (opcao.equals("pesquisar")) {

            String cmpPesquisa = request.getParameter("cmpPesquisa");

            if (cmpPesquisa.equals("")) {
                request.getRequestDispatcher("JnlCnsltCategoriaRisco.jsp").forward(request, response);
            } else {
                CategoriaRiscoDAO sed = DAOFactory.createCategoraiRiscoDAO();
                sed.pesquisar(cmpPesquisa);
                request.getRequestDispatcher("JnlPesqCategoriaRisco.jsp").forward(request, response);
            }
        }

    }

}
