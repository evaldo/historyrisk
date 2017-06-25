package br.cesjf.Controller;

import br.cesjf.classes.CategoriaRisco;
import br.cesjf.classes.FaixaProbabilidade;
import br.cesjf.classes.NivelImpacto;
import br.cesjf.classes.Projeto;
import br.cesjf.classes.Risco;
import br.cesjf.classes.SubCategoriaRisco;
import br.cesjf.classes.Usuario;
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
import javax.servlet.http.HttpSession;

public class RiscoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String opcao = request.getParameter("opcao");
        int idHrskRisco = Integer.parseInt(request.getParameter("idHrskRisco"));

        if (opcao.equals("excluir")) {

            RiscoDAO rsc = DAOFactory.createRiscoDAO();
            rsc.remover(idHrskRisco);
            request.getRequestDispatcher("JnlCnsltRisco.jsp").forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession sessao = request.getSession();

        String opcao = request.getParameter("opcao");

        if (opcao.equals("incluir")) {

            Double nuPerctProbRisco = Double.parseDouble(request.getParameter("nuPerctProbRisco"));
            int idFaixaProbabilidade = Integer.parseInt(request.getParameter("faixaProbabilidade"));
            int idCategoriaRisco = Integer.parseInt(request.getParameter("categoriaRisco"));
            int idSubCategoriaRisco = Integer.parseInt(request.getParameter("subCategoriaRisco"));
            int idNivelImpacto = Integer.parseInt(request.getParameter("nivelImpacto"));
            int idProjeto = Integer.parseInt(request.getParameter("projeto"));
            String dsRisco = request.getParameter("dsRisco");
            Double vlCustoEstmdRisco = Double.parseDouble(request.getParameter("vlCustoEstmdRisco"));
            String icRiscoOcrrdPrjt = request.getParameter("icRiscoOcrrdPrjt");
            if (icRiscoOcrrdPrjt == null) {
                icRiscoOcrrdPrjt = "n";
            }
            String obRiscoOcrrdPrjt = request.getParameter("obRiscoOcrrdPrjt");

            Usuario usuario = new Usuario();
            String nuMatrIncs = (String) sessao.getAttribute("nuMatrIncs");
            usuario.setNuMatrIncs(nuMatrIncs);

            Risco risco = new Risco();

            FaixaProbabilidade faixaProbabilidade = new FaixaProbabilidade();
            faixaProbabilidade.setIdFaixaProb(idFaixaProbabilidade);

            CategoriaRisco categoriaRisco = new CategoriaRisco();
            categoriaRisco.setIdCategoriaRisco(idCategoriaRisco);

            SubCategoriaRisco subCategoriaRisco = new SubCategoriaRisco();
            subCategoriaRisco.setIdSubCatgRisco(idSubCategoriaRisco);

            NivelImpacto nivelImpacto = new NivelImpacto();
            nivelImpacto.setIdNivelIpcto(idNivelImpacto);

            Projeto projeto = new Projeto();
            projeto.setIdHrskprjt(idProjeto);

            risco.setNuPerctProbRisco(nuPerctProbRisco);
            risco.setFaixaProbabilidade(faixaProbabilidade);
            risco.setCategoriaRisco(categoriaRisco);
            risco.setSubCategoriaRisco(subCategoriaRisco);
            risco.setNivelImpacto(nivelImpacto);
            risco.setProjeto(projeto);
            risco.setDsRisco(dsRisco);
            risco.setVlCustoEstmdRisco(vlCustoEstmdRisco);
            risco.setIcRiscoOcrrdPrjt(icRiscoOcrrdPrjt);
            risco.setObRiscoOcrrdPrjt(obRiscoOcrrdPrjt);

            risco.setNuMatrIncs(usuario);
            risco.setDtIncs(new Date());

            RiscoDAO rsc = DAOFactory.createRiscoDAO();
            rsc.inserir(risco);
            request.getRequestDispatcher("JnlCnsltRisco.jsp").forward(request, response);
        }

        if (opcao.equals("alterar")) {

            Double nuPerctProbRisco = Double.parseDouble(request.getParameter("nuPerctProbRisco"));
            int idFaixaProbabilidade = Integer.parseInt(request.getParameter("faixaProbabilidade"));
            int idCategoriaRisco = Integer.parseInt(request.getParameter("categoriaRisco"));
            int idSubCategoriaRisco = Integer.parseInt(request.getParameter("subCategoriaRisco"));
            int idNivelImpacto = Integer.parseInt(request.getParameter("nivelImpacto"));
            int idProjeto = Integer.parseInt(request.getParameter("projeto"));
            String dsRisco = request.getParameter("dsRisco");
            Double vlCustoEstmdRisco = Double.parseDouble(request.getParameter("vlCustoEstmdRisco"));
            String icRiscoOcrrdPrjt = request.getParameter("icRiscoOcrrdPrjt");
            if (icRiscoOcrrdPrjt == null) {
                icRiscoOcrrdPrjt = "n";
            }
            String obRiscoOcrrdPrjt = request.getParameter("obRiscoOcrrdPrjt");

            Usuario usuario = new Usuario();
            String nuMatrIncs = (String) sessao.getAttribute("nuMatrIncs");
            usuario.setNuMatrIncs(nuMatrIncs);

            Risco risco = new Risco();

            FaixaProbabilidade faixaProbabilidade = new FaixaProbabilidade();
            faixaProbabilidade.setIdFaixaProb(idFaixaProbabilidade);

            CategoriaRisco categoriaRisco = new CategoriaRisco();
            categoriaRisco.setIdCategoriaRisco(idCategoriaRisco);

            SubCategoriaRisco subCategoriaRisco = new SubCategoriaRisco();
            subCategoriaRisco.setIdSubCatgRisco(idSubCategoriaRisco);

            NivelImpacto nivelImpacto = new NivelImpacto();
            nivelImpacto.setIdNivelIpcto(idNivelImpacto);

            Projeto projeto = new Projeto();
            projeto.setIdHrskprjt(idProjeto);

            risco.setNuPerctProbRisco(nuPerctProbRisco);
            risco.setFaixaProbabilidade(faixaProbabilidade);
            risco.setCategoriaRisco(categoriaRisco);
            risco.setSubCategoriaRisco(subCategoriaRisco);
            risco.setNivelImpacto(nivelImpacto);
            risco.setProjeto(projeto);
            risco.setDsRisco(dsRisco);
            risco.setVlCustoEstmdRisco(vlCustoEstmdRisco);
            risco.setIcRiscoOcrrdPrjt(icRiscoOcrrdPrjt);
            risco.setObRiscoOcrrdPrjt(obRiscoOcrrdPrjt);

            int idHrskRisco = Integer.parseInt(request.getParameter("idHrskRisco"));
            risco.setIdHrskRisco(idHrskRisco);

            risco.setNuMatrAltr(usuario);
            risco.setDtAltr(new Date());

            RiscoDAO rsc = DAOFactory.createRiscoDAO();
            rsc.editar(risco);
            request.getRequestDispatcher("JnlCnsltRisco.jsp").forward(request, response);
        }

        if (opcao.equals("pesquisar")) {

            String cmpPesquisa = request.getParameter("cmpPesquisa");
            if (cmpPesquisa.equals("")) {
                request.getRequestDispatcher("JnlCnsltRisco.jsp").forward(request, response);
            } else {
                RiscoDAO rsc = DAOFactory.createRiscoDAO();
                rsc.pesquisar(cmpPesquisa);
                request.getRequestDispatcher("JnlPesqRisco.jsp").forward(request, response);

            }
        }

    }

}
