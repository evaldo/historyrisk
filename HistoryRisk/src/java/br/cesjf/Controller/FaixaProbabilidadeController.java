package br.cesjf.Controller;

import br.cesjf.classes.FaixaProbabilidade;
import br.cesjf.classes.Usuario;
import br.cesjf.dao.FaixaProbabilidadeDAO;
import br.cesjf.util.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FaixaProbabilidadeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String opcao = request.getParameter("opcao");
        int idFaixaProb = Integer.parseInt(request.getParameter("idFaixaProb"));

        if (opcao.equals("excluir")) {

            FaixaProbabilidadeDAO fxpb = DAOFactory.createFaixaProbabilidadeDAO();
            fxpb.remover(idFaixaProb);

            request.getRequestDispatcher("JnlCnsltFaixaProbabilidade.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession sessao = request.getSession();

        String opcao = request.getParameter("opcao");

        if (opcao.equals("incluir")) {

            String dsFaixaProb = request.getParameter("dsFaixaProb");
            int nuLmteInfr = Integer.parseInt(request.getParameter("nuLmteInfr"));
            int nuLmteSupr = Integer.parseInt(request.getParameter("nuLmteSupr"));

            Usuario usuario = new Usuario();
            String nuMatrIncs = (String) sessao.getAttribute("nuMatrIncs");
            usuario.setNuMatrIncs(nuMatrIncs);

            FaixaProbabilidade faixaProbabilidade = new FaixaProbabilidade();

            faixaProbabilidade.setDsFaixaProb(dsFaixaProb);
            faixaProbabilidade.setNuLmteInfr(nuLmteInfr);
            faixaProbabilidade.setNuLmteSupr(nuLmteSupr);

            faixaProbabilidade.setNuMatrIncs(usuario);
            faixaProbabilidade.setDtIncs(new Date());

            FaixaProbabilidadeDAO sed = DAOFactory.createFaixaProbabilidadeDAO();
            sed.inserir(faixaProbabilidade);
            request.getRequestDispatcher("JnlCnsltFaixaProbabilidade.jsp").forward(request, response);
        }

        if (opcao.equals("alterar")) {

            String dsFaixaProb = request.getParameter("dsFaixaProb");
            int nuLmteInfr = Integer.parseInt(request.getParameter("nuLmteInfr"));
            int nuLmteSupr = Integer.parseInt(request.getParameter("nuLmteSupr"));

            Usuario usuario = new Usuario();
            String nuMatrIncs = (String) sessao.getAttribute("nuMatrIncs");
            usuario.setNuMatrIncs(nuMatrIncs);

            FaixaProbabilidade faixaProbabilidade = new FaixaProbabilidade();

            faixaProbabilidade.setDsFaixaProb(dsFaixaProb);
            faixaProbabilidade.setNuLmteInfr(nuLmteInfr);
            faixaProbabilidade.setNuLmteSupr(nuLmteSupr);

            int idFaixaProb = Integer.parseInt(request.getParameter("idFaixaProb"));
            faixaProbabilidade.setIdFaixaProb(idFaixaProb);

            faixaProbabilidade.setNuMatrAltr(usuario);
            faixaProbabilidade.setDtAltr(new Date());

            FaixaProbabilidadeDAO sed = DAOFactory.createFaixaProbabilidadeDAO();
            sed.editar(faixaProbabilidade);
            request.getRequestDispatcher("JnlCnsltFaixaProbabilidade.jsp").forward(request, response);

        }

        if (opcao.equals("pesquisar")) {

            String cmpPesquisa = request.getParameter("cmpPesquisa");

            if (cmpPesquisa.equals("")) {
                request.getRequestDispatcher("JnlCnsltFaixaProbabilidade.jsp").forward(request, response);
            } else {
                FaixaProbabilidadeDAO sed = DAOFactory.createFaixaProbabilidadeDAO();
                sed.pesquisar(cmpPesquisa);
                request.getRequestDispatcher("JnlPesqFaixaProbabilidade.jsp").forward(request, response);
            }
        }

    }

}
