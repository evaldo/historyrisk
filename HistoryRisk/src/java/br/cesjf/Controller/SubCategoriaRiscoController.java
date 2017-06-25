package br.cesjf.Controller;

import br.cesjf.classes.CategoriaRisco;
import br.cesjf.classes.SubCategoriaRisco;
import br.cesjf.classes.Usuario;
import br.cesjf.dao.SubCategoriaRiscoDAO;
import br.cesjf.util.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SubCategoriaRiscoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String opcao = request.getParameter("opcao");
        int idCategoriaRisco = Integer.parseInt(request.getParameter("idCategoriaRisco"));

        if (opcao.equals("excluir")) {

            SubCategoriaRiscoDAO ctgr = DAOFactory.createSubCategoriaRiscoDAO();
            ctgr.remover(idCategoriaRisco);

            request.getRequestDispatcher("JnlCnsltSubCategoriaRisco.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession sessao = request.getSession();

        String opcao = request.getParameter("opcao");

        if (opcao.equals("incluir")) {

            int categoriaRisco = Integer.parseInt(request.getParameter("categoriaRisco"));
            CategoriaRisco ctgRisco = new CategoriaRisco();
            ctgRisco.setIdCategoriaRisco(categoriaRisco);

            String dsSubCatgRisco = request.getParameter("dsSubCatgRisco");

            SubCategoriaRisco subCategoriaRisco = new SubCategoriaRisco();
            subCategoriaRisco.setIdCategoriaRisco(ctgRisco);
            subCategoriaRisco.setDsSubCatgRisco(dsSubCatgRisco);

            Usuario usuario = new Usuario();
            String nuMatrIncs = (String) sessao.getAttribute("nuMatrIncs");
            usuario.setNuMatrIncs(nuMatrIncs);

            subCategoriaRisco.setNuMatrIncs(usuario);
            subCategoriaRisco.setDtIncs(new Date());

            SubCategoriaRiscoDAO scr = DAOFactory.createSubCategoriaRiscoDAO();
            scr.inserir(subCategoriaRisco);
            request.getRequestDispatcher("JnlCnsltSubCategoriaRisco.jsp").forward(request, response);

        }
        if (opcao.equals("alterar")) {

            int idSubCatgRisco = Integer.parseInt(request.getParameter("idSubCatgRisco"));

            int categoriaRisco = Integer.parseInt(request.getParameter("categoriaRisco"));
            CategoriaRisco ctgRisco = new CategoriaRisco();
            ctgRisco.setIdCategoriaRisco(categoriaRisco);

            String dsSubCatgRisco = request.getParameter("dsSubCatgRisco");

            SubCategoriaRisco subCategoriaRisco = new SubCategoriaRisco();
            subCategoriaRisco.setIdSubCatgRisco(idSubCatgRisco);
            subCategoriaRisco.setIdCategoriaRisco(ctgRisco);
            subCategoriaRisco.setDsSubCatgRisco(dsSubCatgRisco);

            Usuario usuario = new Usuario();
            String nuMatrIncs = (String) sessao.getAttribute("nuMatrIncs");
            usuario.setNuMatrIncs(nuMatrIncs);

            subCategoriaRisco.setNuMatrAltr(usuario);
            subCategoriaRisco.setDtAltr(new Date());

            SubCategoriaRiscoDAO sed = DAOFactory.createSubCategoriaRiscoDAO();
            sed.editar(subCategoriaRisco);
            request.getRequestDispatcher("JnlCnsltSubCategoriaRisco.jsp").forward(request, response);
        }

        if (opcao.equals("pesquisar")) {

            String cmpPesquisa = request.getParameter("cmpPesquisa");

            if (cmpPesquisa.equals("")) {
                request.getRequestDispatcher("JnlCnsltSubCategoriaRisco.jsp").forward(request, response);
            } else {
                SubCategoriaRiscoDAO sed = DAOFactory.createSubCategoriaRiscoDAO();
                sed.pesquisar(cmpPesquisa);
                request.getRequestDispatcher("JnlCnsltSubCategoriaRisco.jsp").forward(request, response);
            }
        }

    }

}
