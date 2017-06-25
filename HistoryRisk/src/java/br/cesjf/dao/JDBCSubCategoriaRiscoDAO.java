package br.cesjf.dao;

import br.cesjf.classes.CategoriaRisco;
import br.cesjf.classes.SubCategoriaRisco;
import br.cesjf.util.ConnectionFactory;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCSubCategoriaRiscoDAO implements SubCategoriaRiscoDAO {

    Connection connection;

    public JDBCSubCategoriaRiscoDAO() {
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void inserir(SubCategoriaRisco subCategoriaRisco) {

        try {
            String SQL = "INSERT INTO tb_hrsk_subcatg_risco (ID_CATG_RISCO, DS_SUBCATG_RISCO, NU_MATR_INCS, DT_INCS) VALUES"
                    + "(?, ?, ?, ?)";
            PreparedStatement usr = (PreparedStatement) connection.prepareStatement(SQL);
            usr.setInt(1, subCategoriaRisco.getIdCategoriaRisco().getIdCategoriaRisco());
            usr.setString(2, subCategoriaRisco.getDsSubCatgRisco());
            usr.setString(3, subCategoriaRisco.getNuMatrIncs().getNuMatrIncs());
            usr.setDate(4, new java.sql.Date(subCategoriaRisco.getDtIncs().getTime()));

            usr.executeUpdate();
            usr.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao inserir SubCategoriaRisco em JDBCSubCategoriaRiscoDAO", ex);
        }
    }

    @Override
    public void remover(int id) {

        try {
            String SQL = "DELETE FROM tb_hrsk_subcatg_risco WHERE ID_SUBCATG_RISCO = ?";
            PreparedStatement se = (PreparedStatement) connection.prepareStatement(SQL);
            se.setInt(1, id);
            se.executeUpdate();

            se.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao remover SubCategoriaRisco em JDBCSubCategoriaRiscoDAO", ex);
        }
    }

    @Override
    public List<SubCategoriaRisco> listar() {

        List<SubCategoriaRisco> riscos = new ArrayList<>();
        try {
            String SQL = "select * from tb_hrsk_subcatg_risco";
            PreparedStatement rsc = (PreparedStatement) connection.prepareStatement(SQL);
            ResultSet rs = rsc.executeQuery();
            while (rs.next()) {
                SubCategoriaRisco subCategoriaRisco = new SubCategoriaRisco();
                subCategoriaRisco.setIdSubCatgRisco(rs.getInt("ID_SUBCATG_RISCO"));

                JDBCCategoriaRiscoDAO ctgr = new JDBCCategoriaRiscoDAO();
                CategoriaRisco categoriaRisco = ctgr.buscar(rs.getInt("ID_CATG_RISCO"));
                subCategoriaRisco.setIdCategoriaRisco(categoriaRisco);

                subCategoriaRisco.setDsSubCatgRisco(rs.getString("DS_SUBCATG_RISCO"));

                riscos.add(subCategoriaRisco);
            }
            rsc.close();
            rs.close();
            connection.close();

            return riscos;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCRiscoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar SubCategoriaRisco em JDBCSubCategoriaRiscoDAO", ex);
        }
    }

    @Override
    public SubCategoriaRisco buscar(int idSubCatgRisco) {
        SubCategoriaRisco subCategoriaRisco = new SubCategoriaRisco();

        try {
            String SQL = "SELECT * FROM tb_hrsk_subcatg_risco WHERE ID_SUBCATG_RISCO = ?";
            PreparedStatement rsc = (PreparedStatement) connection.prepareStatement(SQL);
            rsc.setInt(1, idSubCatgRisco);
            ResultSet rs = rsc.executeQuery();

            rs.next();

            subCategoriaRisco.setIdSubCatgRisco(rs.getInt("ID_SUBCATG_RISCO"));

            JDBCCategoriaRiscoDAO ctgr = new JDBCCategoriaRiscoDAO();
            CategoriaRisco categoriaRisco = ctgr.buscar(rs.getInt("ID_CATG_RISCO"));
            subCategoriaRisco.setIdCategoriaRisco(categoriaRisco);

            subCategoriaRisco.setDsSubCatgRisco(rs.getString("DS_SUBCATG_RISCO"));

            rsc.close();
            rs.close();
            connection.close();

            return subCategoriaRisco;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar a SubCategoriaRisco desejado em JDBCSubCategoriaRiscoDAO", ex);
        }
    }

    @Override
    public void editar(SubCategoriaRisco subCategoriaRisco) {
        try {
            String SQL = "UPDATE tb_hrsk_subcatg_risco SET ID_CATG_RISCO=?, DS_SUBCATG_RISCO=?, NU_MATR_ALTR=?, DT_ALTR=? where ID_SUBCATG_RISCO=?";
            PreparedStatement rsc = (PreparedStatement) connection.prepareStatement(SQL);

            rsc.setInt(1, subCategoriaRisco.getIdCategoriaRisco().getIdCategoriaRisco());
            rsc.setString(2, subCategoriaRisco.getDsSubCatgRisco());
            rsc.setString(3, subCategoriaRisco.getNuMatrAltr().getNuMatrIncs());
            rsc.setDate(4, new java.sql.Date(subCategoriaRisco.getDtAltr().getTime()));
            rsc.setInt(5, subCategoriaRisco.getIdSubCatgRisco());

            rsc.executeUpdate();
            rsc.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao atualizar a SubCategoria desejado em JDBCSubCategoriaDAO", ex);
        }
    }

    @Override
    public List<SubCategoriaRisco> pesquisar(String pesq) {
        List<SubCategoriaRisco> subCategoriasRisco = new ArrayList<>();
        try {
            String SQL = "select * from tb_hrsk_subcatg_risco where DS_SUBCATG_RISCO like ?";
            PreparedStatement rsc = (PreparedStatement) connection.prepareStatement(SQL);
            rsc.setString(1, "%" + pesq + "%");
            ResultSet rs = rsc.executeQuery();
            while (rs.next()) {
                SubCategoriaRisco subCategoriaRisco = new SubCategoriaRisco();

                subCategoriaRisco.setIdSubCatgRisco(rs.getInt("ID_HRSK_RISCO"));

                JDBCCategoriaRiscoDAO ctgr = new JDBCCategoriaRiscoDAO();
                CategoriaRisco categoriaRisco = ctgr.buscar(rs.getInt("ID_CATG_RISCO"));
                subCategoriaRisco.setIdCategoriaRisco(categoriaRisco);

                subCategoriaRisco.setDsSubCatgRisco(rs.getString("DS_SUBCATG_RISCO"));

                subCategoriasRisco.add(subCategoriaRisco);
            }
            rsc.close();
            rs.close();
            connection.close();
            return subCategoriasRisco;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCRiscoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar SubCategoriaRisco em JDBCSubCategoriaRiscoDAO", ex);
        }
    }

    @Override
    public List<SubCategoriaRisco> getByCategoriaRisco(int idCategoriaRisco) {
        List<SubCategoriaRisco> riscos = new ArrayList<>();
        try {
            String SQL = "select * from tb_hrsk_subcatg_risco where ID_CATG_RISCO = ?";
            PreparedStatement rsc = (PreparedStatement) connection.prepareStatement(SQL);
            rsc.setInt(1, idCategoriaRisco);
            ResultSet rs = rsc.executeQuery();
            while (rs.next()) {
                SubCategoriaRisco subCategoriaRisco = new SubCategoriaRisco();
                subCategoriaRisco.setIdSubCatgRisco(rs.getInt("ID_SUBCATG_RISCO"));

                JDBCCategoriaRiscoDAO ctgr = new JDBCCategoriaRiscoDAO();
                CategoriaRisco categoriaRisco = ctgr.buscar(rs.getInt("ID_CATG_RISCO"));
                subCategoriaRisco.setIdCategoriaRisco(categoriaRisco);

                subCategoriaRisco.setDsSubCatgRisco(rs.getString("DS_SUBCATG_RISCO"));

                riscos.add(subCategoriaRisco);
            }
            rsc.close();
            rs.close();
            connection.close();

            return riscos;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCRiscoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar SubCategoriaRisco em JDBCSubCategoriaRiscoDAO", ex);
        }
    }

}
