package br.cesjf.dao;

import br.cesjf.classes.CategoriaRisco;
import br.cesjf.classes.Usuario;
import br.cesjf.util.ConnectionFactory;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCCategoriaRiscoDAO implements CategoriaRiscoDAO {

    Connection connection;

    public JDBCCategoriaRiscoDAO() {
        
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void inserir(CategoriaRisco categoriaRisco) {
        try {
            String SQL = "INSERT INTO tb_hrsk_catg_risco (DS_CATG_RISCO, NU_MATR_INCS, DT_INCS) VALUES"
                    + "(?, ?, ?)";
            PreparedStatement se = (PreparedStatement) connection.prepareStatement(SQL);
            se.setString(1, categoriaRisco.getDsCategoriaRisco());
            se.setString(2, categoriaRisco.getNuMatrIncs().getNuMatrIncs());
            se.setDate(3, new java.sql.Date(categoriaRisco.getDtIncs().getTime()));

            se.executeUpdate();
            se.close();
            se.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCCategoriaRiscoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao inserir Categoria Risco em JDBCCategoriaRiscoDAO.", ex);
        }
    }

    @Override
    public void remover(int id) {
        try {
            String SQL = "DELETE FROM tb_hrsk_catg_risco WHERE ID_CATG_RISCO = ?";
            PreparedStatement se = (PreparedStatement) connection.prepareStatement(SQL);
            se.setInt(1, id);
            se.executeUpdate();
            
            se.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao remover SetorEmpresa em JDBCSetorEmpresaDAO", ex);
        }
    }

    @Override
    public List<CategoriaRisco> listar() {
        List<CategoriaRisco> setoresEmpresa = new ArrayList<>();
        try {
            String SQL = "select * from tb_hrsk_catg_risco";
            PreparedStatement se = (PreparedStatement) connection.prepareStatement(SQL);
            ResultSet rs = se.executeQuery();
            while (rs.next()) {
                CategoriaRisco categoriaRisco = new CategoriaRisco();
                categoriaRisco.setIdCategoriaRisco(rs.getInt("ID_CATG_RISCO"));
                categoriaRisco.setDsCategoriaRisco(rs.getString("DS_CATG_RISCO"));

                setoresEmpresa.add(categoriaRisco);
            }
            se.close();
            rs.close();
            connection.close();
            return setoresEmpresa;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar SetorEmpresa em JDBCCategoriaRisco", ex);
        }
    }

    @Override
    public CategoriaRisco buscar(int id) {
        CategoriaRisco categoriaRisco = new CategoriaRisco();

        try {
            String SQL = "SELECT * FROM tb_hrsk_catg_risco WHERE ID_CATG_RISCO = ?";
            PreparedStatement ctgr = (PreparedStatement) connection.prepareStatement(SQL);
            ctgr.setInt(1, id);
            ResultSet rs = ctgr.executeQuery();

            rs.next();
            categoriaRisco.setIdCategoriaRisco(rs.getInt("ID_CATG_RISCO"));
            categoriaRisco.setDsCategoriaRisco(rs.getString("DS_CATG_RISCO"));

            ctgr.close();
            rs.close();
            connection.close();

            return categoriaRisco;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar o SetorEmpresa desejado em JDBCSetorEmpresaDAO", ex);
        }
    }

    @Override
    public void editar(CategoriaRisco categoriaRisco) {

        try {
            String SQL = "UPDATE tb_hrsk_catg_risco SET DS_CATG_RISCO=?, NU_MATR_ALTR=?, DT_ALTR=? where ID_CATG_RISCO=? ";
            PreparedStatement se = (PreparedStatement) connection.prepareStatement(SQL);
            se.setString(1, categoriaRisco.getDsCategoriaRisco());
            se.setString(2, categoriaRisco.getNuMatrAltr().getNuMatrIncs());
            se.setDate(3, new java.sql.Date(categoriaRisco.getDtAltr().getTime()));
            se.setInt(4, categoriaRisco.getIdCategoriaRisco());

            se.executeUpdate();
            se.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao atualizar a Categoria de Risco desejado em JDBCCategoriaRiscoDAO", ex);
        }
    }

    @Override
    public List<CategoriaRisco> pesquisar(String pesq) {
        List<CategoriaRisco> categoriasRisco = new ArrayList<>();
        try {
            String SQL = "select * from tb_hrsk_catg_risco where DS_CATG_RISCO like ? ";
            PreparedStatement ctgr = (PreparedStatement) connection.prepareStatement(SQL);
            ctgr.setString(1, "%" + pesq + "%");
            ResultSet rs = ctgr.executeQuery();
            while (rs.next()) {
                CategoriaRisco categoriaRisco = new CategoriaRisco();
                categoriaRisco.setIdCategoriaRisco(rs.getInt("ID_CATG_RISCO"));
                categoriaRisco.setDsCategoriaRisco(rs.getString("DS_CATG_RISCO"));

                JDBCUsuarioDAO usr = new JDBCUsuarioDAO();
                Usuario usuario = usr.buscar(rs.getString("NU_MATR_INCS"));
                categoriaRisco.setNuMatrIncs(usuario);

                categoriaRisco.setDtIncs(rs.getDate("DT_INCS"));
                categoriasRisco.add(categoriaRisco);
            }
            ctgr.close();
            rs.close();
            connection.close();
            return categoriasRisco;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar SetorEmpresa em JDBCCategoriaRisco", ex);
        }
    }
    
    

}
