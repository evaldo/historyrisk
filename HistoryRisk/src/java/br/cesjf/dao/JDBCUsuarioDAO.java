package br.cesjf.dao;

import br.cesjf.classes.Usuario;
import br.cesjf.util.ConnectionFactory;
import com.mysql.jdbc.Connection;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCUsuarioDAO implements UsuarioDAO {

    Connection connection;

    public JDBCUsuarioDAO() {
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void inserir(Usuario usuario) {

        try {
            String SQL = "INSERT INTO tb_hrsk_usua (NM_USUA, EMAIL_USUA, USR_USUA, PSW_USUA, DT_INCS) VALUES"
                    + "(?, ?, ?, ?, ?)";
            PreparedStatement usr = (PreparedStatement) connection.prepareStatement(SQL);
            usr.setString(1, usuario.getNmIncs());
            usr.setString(2, usuario.getEmailIncs());
            usr.setString(3, usuario.getUsrIncs());
            usr.setString(4, usuario.getPswIncs());
            usr.setDate(5, new java.sql.Date(usuario.getDtIncs().getTime()));

            usr.executeUpdate();
            usr.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao inserir Usuario em JDBCUsuarioDAO", ex);
        }
    }

    @Override
    public void remover(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            String SQL = "select * from tb_hrsk_usua";
            PreparedStatement usr = (PreparedStatement) connection.prepareStatement(SQL);
            ResultSet rs = usr.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setNuMatrIncs(rs.getString("NU_MATR_USUA"));
                usuario.setNmIncs(rs.getString("NM_USUA"));
                usuario.setEmailIncs(rs.getString("EMAIL_USUA"));
                usuario.setUsrIncs(rs.getString("USR_USUA"));
                usuario.setPswIncs(rs.getString("PSW_USUA"));
                usuario.setDtIncs(rs.getDate("DT_INCS"));
                usuarios.add(usuario);
            }
            usr.close();
            rs.close();
            connection.close();
            return usuarios;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar Usuario em JDBCUsuarioDAO", ex);
        }
    }

    @Override
    public Usuario buscar(String nuMatrIncs) {
        Usuario usuario = new Usuario();

        try {
            String SQL = "SELECT * FROM tb_hrsk_usua WHERE NU_MATR_USUA = ?";
            PreparedStatement se = (PreparedStatement) connection.prepareStatement(SQL);
            se.setString(1, nuMatrIncs);
            ResultSet rs = se.executeQuery();

            if (rs.next()) {
                usuario.setNuMatrIncs(rs.getString("NU_MATR_USUA"));
                usuario.setNmIncs(rs.getString("NM_USUA"));
                usuario.setEmailIncs(rs.getString("EMAIL_USUA"));
                usuario.setUsrIncs(rs.getString("USR_USUA"));
                usuario.setPswIncs(rs.getString("PSW_USUA"));
                usuario.setDtIncs(rs.getDate("DT_INCS"));

                se.close();
                rs.close();
                connection.close();

                return usuario;
            }
            return usuario = null;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar o Usuario desejado em JDBCUsuarioDAO", ex);
        }
    }

    @Override
    public void editar(Usuario usuario) {
        try {
            String SQL = "UPDATE tb_hrsk_usua SET NM_USUA=?, EMAIL_USUA=?, USR_USUA=?, PSW_USUA=? where NU_MATR_USUA=? ";
            PreparedStatement se = (PreparedStatement) connection.prepareStatement(SQL);
            se.setString(1, usuario.getNmIncs());
            se.setString(2, usuario.getEmailIncs());
            se.setString(3, usuario.getUsrIncs());
            se.setString(4, usuario.getPswIncs());
            se.setString(5, usuario.getNuMatrIncs());

            se.executeUpdate();
            se.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao atualizar o SetorEmpresa desejado em JDBCSetorEmpresaDAO", ex);
        }
    }

    public Usuario buscarUsrPsw(Usuario usuario) {

        try {
            String SQL = "SELECT * FROM tb_hrsk_usua WHERE USR_USUA = ? and PSW_USUA = ?";
            PreparedStatement se = (PreparedStatement) connection.prepareStatement(SQL);
            se.setString(1, usuario.getUsrIncs());
            se.setString(2, usuario.getPswIncs());

            ResultSet rs = se.executeQuery();

            if (rs.next()) {
                usuario.setNuMatrIncs(rs.getString("NU_MATR_USUA"));
                usuario.setNmIncs(rs.getString("NM_USUA"));
                usuario.setEmailIncs(rs.getString("EMAIL_USUA"));
                usuario.setUsrIncs(rs.getString("USR_USUA"));
                usuario.setPswIncs(rs.getString("PSW_USUA"));
                usuario.setDtIncs(rs.getDate("DT_INCS"));

                se.close();
                rs.close();
                connection.close();
                return usuario;
            }

            return usuario = null;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar o Usuario desejado em JDBCUsuarioDAO", ex);
        }
    }

}
