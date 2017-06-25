package br.cesjf.Controller;

import br.cesjf.classes.SetorEmpresa;
import br.cesjf.classes.Usuario;
import br.cesjf.dao.SetorEmpresaDAO;
import br.cesjf.util.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SetorEmpresaController", urlPatterns = {"/SetorEmpresaController"})
public class SetorEmpresaController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String opcao = request.getParameter("opcao");
        int idSetorEmpr = Integer.parseInt(request.getParameter("idSetorEmpr"));

        if (opcao.equals("excluir")) {

            SetorEmpresa setorEmpresa = new SetorEmpresa();
            setorEmpresa.setIdSetorEmpr(idSetorEmpr);

            SetorEmpresaDAO sed = DAOFactory.createSetorEmpresaDAO();
            sed.remover(idSetorEmpr);

            request.getRequestDispatcher("JnlCnsltSetorEmpresa.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        
        HttpSession sessao = request.getSession();
        
        String opcao = request.getParameter("opcao");
        String nmSetorEmpr = request.getParameter("nmSetorEmpr");
        
        Usuario usuario = new Usuario();
        String nuMatrIncs = (String) sessao.getAttribute("nuMatrIncs");
        usuario.setNuMatrIncs(nuMatrIncs);
        
        SetorEmpresa setorEmpresa = new SetorEmpresa();
        setorEmpresa.setNmSetorEmpr(nmSetorEmpr);

        if (opcao.equals("incluir")) {

            setorEmpresa.setNuMatrIncs(usuario);
            setorEmpresa.setDtIncs(new Date());

            SetorEmpresaDAO sed = DAOFactory.createSetorEmpresaDAO();
            sed.inserir(setorEmpresa);

            request.getRequestDispatcher("JnlCnsltSetorEmpresa.jsp").forward(request, response);
        }

        if (opcao.equals("alterar")) {
            
            int idSetorEmpr = Integer.parseInt(request.getParameter("idSetorEmpr"));
            setorEmpresa.setIdSetorEmpr(idSetorEmpr);
            setorEmpresa.setNuMatrAltr(usuario);
            setorEmpresa.setDtAltr(new Date());

            SetorEmpresaDAO sed = DAOFactory.createSetorEmpresaDAO();
            sed.editar(setorEmpresa);

            request.getRequestDispatcher("JnlCnsltSetorEmpresa.jsp").forward(request, response);
        }
        
        if (opcao.equals("pesquisar")){
            
            String cmpPesquisa = request.getParameter("cmpPesquisa");
            
            if(cmpPesquisa.equals("")){
                request.getRequestDispatcher("JnlCnsltSetorEmpresa.jsp").forward(request, response);
            }else{
                SetorEmpresaDAO sed = DAOFactory.createSetorEmpresaDAO();
                sed.pesquisar(cmpPesquisa);
                request.getRequestDispatcher("JnlPesqSetorEmpresa.jsp").forward(request, response);
            }  
        }

    }

}
