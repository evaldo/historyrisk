package br.cesjf.dao;

import br.cesjf.classes.NivelImpacto;
import br.cesjf.util.ConnectionFactory;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCNivelImpactoDAO implements NivelImpactoDAO{
    
    Connection connection;

    public JDBCNivelImpactoDAO(){
            connection = ConnectionFactory.getConnection();
    }

    @Override
    public void inserir(NivelImpacto nivelImpacto) {
        
        try {
            String SQL = "INSERT INTO tb_hrsk_nivel_ipcto (ID_NIVEL_IPCTO, NM_NIVEL_IPCTO, DS_NIVEL_IPCTO, IC_NIVEL_IPCTO) VALUES" 
                    + "(?, ?, ?, ?)";
            PreparedStatement se = (PreparedStatement) connection.prepareStatement(SQL);
            se.setInt(1, nivelImpacto.getIdNivelIpcto());
            se.setString(2, nivelImpacto.getNmNivelIpcto());
            se.setString(3, nivelImpacto.getDsNivelIpcto());
            se.setInt(4, nivelImpacto.getIcNivelIpcto());
            
            se.executeUpdate();
            se.close();
        }catch (SQLException ex) {
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
            while(rs.next()){
                NivelImpacto nivelImpacto = new NivelImpacto();
                nivelImpacto.setIdNivelIpcto(rs.getInt("ID_NIVEL_IPCTO"));
                nivelImpacto.setNmNivelIpcto(rs.getString("NM_NIVEL_IPCTO"));
                nivelImpacto.setDsNivelIpcto(rs.getString("DS_NIVEL_IPCTO"));
                nivelImpacto.setIcNivelIpcto(rs.getInt("IC_NIVEL_IPCTO"));
                niveisImpacto.add(nivelImpacto);
            }
            se.close();
            rs.close();
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
            nivelImpacto.setIcNivelIpcto(rs.getInt("IC_NIVEL_IPCTO"));

            nvlipcto.close();
            rs.close();
            
            return nivelImpacto;
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCNivelImpactoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar o Nivel Impacto desejado em JDBCNivelImpactoDAO", ex);
        }
    }

    @Override
    public void editar(NivelImpacto nivelImpacto) {
       try {
            String SQL = "UPDATE tb_hrsk_nivel_ipcto SET NM_NIVEL_IPCTO=?, DS_NIVEL_IPCTO=?, IC_NIVEL_IPCTO=? where ID_NIVEL_IPCTO=?";
            PreparedStatement se = (PreparedStatement) connection.prepareStatement(SQL);
            
            se.setString(1, nivelImpacto.getNmNivelIpcto());
            se.setString(2, nivelImpacto.getDsNivelIpcto());
            se.setInt(3, nivelImpacto.getIcNivelIpcto());
            se.setInt(4, nivelImpacto.getIdNivelIpcto());
            
            se.executeUpdate();
            se.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao atualizar o Nivel Impacto desejado em JDBCNivelImpactoDAO", ex);
        }
    }


}
