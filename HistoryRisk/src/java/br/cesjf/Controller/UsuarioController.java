package br.cesjf.Controller;

import br.cesjf.classes.Usuario;
import br.cesjf.dao.UsuarioDAO;
import br.cesjf.util.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UsuarioController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String opcao = request.getParameter("opcao");
        String nmIncs = request.getParameter("nmIncs");
        String emailIncs = request.getParameter("emailIncs");
        String usrIncs = request.getParameter("usrIncs");
        String pswIncs = request.getParameter("pswIncs");

        Usuario usuario = new Usuario();
        usuario.setNmIncs(nmIncs);
        usuario.setEmailIncs(emailIncs);
        usuario.setUsrIncs(usrIncs);
        usuario.setPswIncs(pswIncs);

        if (opcao.equals("incluir")) {

            usuario.setDtIncs(new Date());

            UsuarioDAO usr = DAOFactory.createUsuarioDAO();
            usr.inserir(usuario);
            request.getRequestDispatcher("JnlCnsltUsuario.jsp").forward(request, response);
        }
        
        if (opcao.equals("alterar")){
            
            String nuMatrIncs = request.getParameter("nuMatrIncs");
            usuario.setNuMatrIncs(nuMatrIncs);
            
            UsuarioDAO usr = DAOFactory.createUsuarioDAO();
            usr.editar(usuario);
            request.getRequestDispatcher("JnlCnsltUsuario.jsp").forward(request, response);
            
        }

    }

}
