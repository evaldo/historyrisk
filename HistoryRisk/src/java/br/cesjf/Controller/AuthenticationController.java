package br.cesjf.Controller;

import br.cesjf.classes.Usuario;
import br.cesjf.dao.JDBCUsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AuthenticationController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession(false);

        String opcao = request.getParameter("opcao");

        if (opcao.equals("sair")) {
            if (sessao != null) {
                sessao.invalidate();
            }

            response.sendRedirect("JnlLogar.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String opcao = request.getParameter("opcao");
        String usrIncs = request.getParameter("usrIncs");
        String pswIncs = request.getParameter("pswIncs");

        Usuario usuario = new Usuario();
        usuario.setUsrIncs(usrIncs);
        usuario.setPswIncs(pswIncs);

        if (opcao.equals("autenticar")) {

            HttpSession sessao = request.getSession();
            JDBCUsuarioDAO usr = new JDBCUsuarioDAO();

            Usuario usrAutenticado = usr.buscarUsrPsw(usuario);

            if (usrAutenticado != null) {

                sessao.setAttribute("nuMatrIncs", usrAutenticado.getNuMatrIncs());
                sessao.setAttribute("nmIncs", usrAutenticado.getNmIncs());
                sessao.setAttribute("usrIncs", usrAutenticado.getNmIncs());

                request.getRequestDispatcher("Index.jsp").forward(request, response);
            } else {

                response.sendRedirect("JnlLogar.jsp");
            }
        }
    }

}
