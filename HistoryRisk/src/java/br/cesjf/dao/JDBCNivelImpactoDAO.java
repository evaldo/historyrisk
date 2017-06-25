package br.cesjf.dao;

import br.cesjf.classes.NivelImpacto;
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

public class JDBCNivelImpactoDAO implements NivelImpactoDAO {

    Connection connection;

    public JDBCNivelImpactoDAO() {
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void inserir(NivelImpacto nivelImpacto) {

        try {
            String SQL = "INSERT INTO tb_hrsk_nivel_ipcto (NM_NIVEL_IPCTO, DS_NIVEL_IPCTO, IC_NIVEL_IPCTO, VL_ASSC_NIVEL_IPCTO, NU_MATL_INCS, DT_INCS) VALUES"
                    + "(?, ?, ?, ?, ?, ?)";
            PreparedStatement se = (PreparedStatement) connection.prepareStatement(SQL);
            se.setString(1, nivelImpacto.getNmNivelIpcto());
            se.setString(2, nivelImpacto.getDsNivelIpcto());
            se.setString(3, nivelImpacto.getIcNivelIpcto());
            se.setDouble(4, nivelImpacto.getVlAsscNivelIpcto());
            se.setString(5, nivelImpacto.getNuMatrIncs().getNuMatrIncs());
            se.setDate(6, new java.sql.Date(nivelImpacto.getDtIncs().getTime()));

            se.executeUpdate();
            se.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(JDBCNivelImpactoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao inserir Nivel Impacto em JDBCNivelImpactoDAO.", ex);
        }
    }

    @Override
    public void remover(int id) {
        try {
            String SQL = "DELETE FROM tb_hrsk_nivel_ipcto WHERE ID_NIVEL_IPCTO = ?";
            PreparedStatement se = (PreparedStatement) connection.prepareStatement(SQL);
            se.setInt(1, id);
            se.executeUpdate();
            se.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao remover Faixa Probabilidade em JDBCFaixaProbabilidadeDAO", ex);
        }
    }

    @Override
    public List<NivelImpacto> listar() {
        List<NivelImpacto> niveisImpacto = new ArrayList<>();
        try {
            String SQL = "select * from tb_hrsk_nivel_ipcto";
            PreparedStatement se = (PreparedStatement) connection.prepareStatement(SQL);
            ResultSet rs = se.executeQuery();
            while (rs.next()) {
                NivelImpacto nivelImpacto = new NivelImpacto();
                nivelImpacto.setIdNivelIpcto(rs.getInt("ID_NIVEL_IPCTO"));
                nivelImpacto.setNmNivelIpcto(rs.getString("NM_NIVEL_IPCTO"));
                nivelImpacto.setDsNivelIpcto(rs.getString("DS_NIVEL_IPCTO"));
                nivelImpacto.setIcNivelIpcto(rs.getString("IC_NIVEL_IPCTO"));
                nivelImpacto.setVlAsscNivelIpcto(rs.getDouble("VL_ASSC_NIVEL_IPCTO"));

                niveisImpacto.add(nivelImpacto);
            }
            se.close();
            rs.close();
            connection.close();
            return niveisImpacto;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar Nivel Impacto em JDBCNivelImpactoDAO", ex);
        }
    }

    @Override
    public NivelImpacto buscar(int id) {
        NivelImpacto nivelImpacto = new NivelImpacto();

        try {
            String SQL = "SELECT * FROM tb_hrsk_nivel_ipcto WHERE ID_NIVEL_IPCTO = ?";
            PreparedStatement nvlipcto = (PreparedStatement) connection.prepareStatement(SQL);
            nvlipcto.setInt(1, id);
            ResultSet rs = nvlipcto.executeQuery();

            rs.next();

            nivelImpacto.setIdNivelIpcto(rs.getInt("ID_NIVEL_IPCTO"));
            nivelImpacto.setNmNivelIpcto(rs.getString("NM_NIVEL_IPCTO"));
            nivelImpacto.setDsNivelIpcto(rs.getString("DS_NIVEL_IPCTO"));
            nivelImpacto.setIcNivelIpcto(rs.getString("IC_NIVEL_IPCTO"));
            nivelImpacto.setVlAsscNivelIpcto(rs.getDouble("VL_ASSC_NIVEL_IPCTO"));

            nvlipcto.close();
            rs.close();
            connection.close();
            return nivelImpacto;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCNivelImpactoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar o Nivel Impacto desejado em JDBCNivelImpactoDAO", ex);
        }
    }

    @Override
    public void editar(NivelImpacto nivelImpacto) {
        try {
            String SQL = "UPDATE tb_hrsk_nivel_ipcto SET NM_NIVEL_IPCTO=?, DS_NIVEL_IPCTO=?, IC_NIVEL_IPCTO=?, VL_ASSC_NIVEL_IPCTO=?, NU_MATL_ALTR=?, DT_ALTR=? where ID_NIVEL_IPCTO=?";
            PreparedStatement se = (PreparedStatement) connection.prepareStatement(SQL);

            se.setString(1, nivelImpacto.getNmNivelIpcto());
            se.setString(2, nivelImpacto.getDsNivelIpcto());
            se.setString(3, nivelImpacto.getIcNivelIpcto());
            se.setDouble(4, nivelImpacto.getVlAsscNivelIpcto());
            se.setString(5, nivelImpacto.getNuMatrAltr().getNuMatrIncs());
            se.setDate(6, new java.sql.Date(nivelImpacto.getDtAltr().getTime()));
            se.setInt(7, nivelImpacto.getIdNivelIpcto());

            se.executeUpdate();
            se.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao atualizar o Nivel Impacto desejado em JDBCNivelImpactoDAO", ex);
        }
    }

    @Override
    public List<NivelImpacto> pesquisar(String pesq) {
        List<NivelImpacto> niveisImpacto = new ArrayList<>();
        try {
            String SQL = "select * from tb_hrsk_nivel_ipcto where DS_NIVEL_IPCTO like ?";
            PreparedStatement se = (PreparedStatement) connection.prepareStatement(SQL);
            se.setString(1, "%" + pesq + "%");
            ResultSet rs = se.executeQuery();
            while (rs.next()) {
                NivelImpacto nivelImpacto = new NivelImpacto();
                nivelImpacto.setIdNivelIpcto(rs.getInt("ID_NIVEL_IPCTO"));
                nivelImpacto.setNmNivelIpcto(rs.getString("NM_NIVEL_IPCTO"));
                nivelImpacto.setDsNivelIpcto(rs.getString("DS_NIVEL_IPCTO"));
                nivelImpacto.setIcNivelIpcto(rs.getString("IC_NIVEL_IPCTO"));
                nivelImpacto.setVlAsscNivelIpcto(rs.getDouble("VL_ASSC_NIVEL_IPCTO"));

                JDBCUsuarioDAO usr = new JDBCUsuarioDAO();
                Usuario usuario = usr.buscar(rs.getString("NU_MATL_INCS"));
                nivelImpacto.setNuMatrIncs(usuario);

                nivelImpacto.setDtIncs(rs.getDate("DT_INCS"));
                niveisImpacto.add(nivelImpacto);
            }
            se.close();
            rs.close();
            connection.close();
            return niveisImpacto;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar Nivel Impacto em JDBCNivelImpactoDAO", ex);
        }
    }

}
