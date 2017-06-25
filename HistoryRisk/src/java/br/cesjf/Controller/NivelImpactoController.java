package br.cesjf.Controller;

import br.cesjf.classes.NivelImpacto;
import br.cesjf.classes.Usuario;
import br.cesjf.dao.NivelImpactoDAO;
import br.cesjf.util.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NivelImpactoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String opcao = request.getParameter("opcao");
        int idNivelIpcto = Integer.parseInt(request.getParameter("idNivelIpcto"));

        if (opcao.equals("excluir")) {

            NivelImpactoDAO nvlimp = DAOFactory.createNivelImpactoDAO();
            nvlimp.remover(idNivelIpcto);

            request.getRequestDispatcher("JnlCnsltNivelImpacto.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        HttpSession sessao = request.getSession();

        String opcao = request.getParameter("opcao");

        if (opcao.equals("incluir")) {

            String nmNivelIpcto = request.getParameter("nmNivelIpcto");
            String dsNivelIpcto = request.getParameter("dsNivelIpcto");
            String icNivelIpcto = request.getParameter("icNivelIpcto");
            Double vlAsscNivelIpcto = Double.parseDouble(request.getParameter("vlAsscNivelIpcto"));

            Usuario usuario = new Usuario();
            String nuMatrIncs = (String) sessao.getAttribute("nuMatrIncs");
            usuario.setNuMatrIncs(nuMatrIncs);

            NivelImpacto nivelImpacto = new NivelImpacto();
            nivelImpacto.setNmNivelIpcto(nmNivelIpcto);
            nivelImpacto.setDsNivelIpcto(dsNivelIpcto);
            nivelImpacto.setIcNivelIpcto(icNivelIpcto);
            nivelImpacto.setVlAsscNivelIpcto(vlAsscNivelIpcto);

            nivelImpacto.setNuMatrIncs(usuario);
            nivelImpacto.setDtIncs(new Date());

            NivelImpactoDAO sed = DAOFactory.createNivelImpactoDAO();
            sed.inserir(nivelImpacto);
        }

        if (opcao.equals("alterar")) {

            String nmNivelIpcto = request.getParameter("nmNivelIpcto");
            String dsNivelIpcto = request.getParameter("dsNivelIpcto");
            String icNivelIpcto = request.getParameter("icNivelIpcto");
            Double vlAsscNivelIpcto = Double.parseDouble(request.getParameter("vlAsscNivelIpcto"));

            Usuario usuario = new Usuario();
            String nuMatrIncs = (String) sessao.getAttribute("nuMatrIncs");
            usuario.setNuMatrIncs(nuMatrIncs);

            NivelImpacto nivelImpacto = new NivelImpacto();
            nivelImpacto.setNmNivelIpcto(nmNivelIpcto);
            nivelImpacto.setDsNivelIpcto(dsNivelIpcto);
            nivelImpacto.setIcNivelIpcto(icNivelIpcto);
            nivelImpacto.setVlAsscNivelIpcto(vlAsscNivelIpcto);
            int idNivelIpcto = Integer.parseInt(request.getParameter("idNivelIpcto"));
            nivelImpacto.setIdNivelIpcto(idNivelIpcto);

            nivelImpacto.setNuMatrAltr(usuario);
            nivelImpacto.setDtAltr(new Date());

            NivelImpactoDAO sed = DAOFactory.createNivelImpactoDAO();
            sed.editar(nivelImpacto);
        }

        if (opcao.equals("pesquisar")) {
            String cmpPesquisa = request.getParameter("cmpPesquisa");

            if (cmpPesquisa.equals("")) {
                request.getRequestDispatcher("JnlCnsltNivelImpacto.jsp").forward(request, response);
            } else {
                NivelImpactoDAO sed = DAOFactory.createNivelImpactoDAO();
                sed.pesquisar(cmpPesquisa);
                request.getRequestDispatcher("JnlPesqNivelImpacto.jsp").forward(request, response);
            }
        }

        request.getRequestDispatcher("JnlCnsltNivelImpacto.jsp").forward(request, response);
    }

}
