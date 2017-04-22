package br.cesjf.dao;

import br.cesjf.util.ConnectionFactory;
import br.cesjf.classes.SetorEmpresa;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCSetorEmpresaDAO implements SetorEmpresaDAO {
    
    Connection connection;
    public JDBCSetorEmpresaDAO(){
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void inserir(SetorEmpresa setorEmpresa) {
        
        try {
            String SQL = "INSERT INTO tb_setor_empr (ID_SETOR_EMPR, NM_SETOR_EMPR) VALUES" 
                    + "(?, ?)";
            PreparedStatement se = (PreparedStatement) connection.prepareStatement(SQL);
            se.setInt(1, setorEmpresa.getIdSetorEmpr());
            se.setString(2, setorEmpresa.getNmSetorEmpr());
            
            se.executeUpdate();
            se.close();
        }catch (SQLException ex) {
             Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
             throw new RuntimeException("Falha ao inserir SetorEmpresa em JDBCSetorEmpresaDAO", ex);
        }
        
    }

    @Override
    public void remover(int id) {
      
        try {
            String SQL = "DELETE FROM tb_setor_empr WHERE ID_SETOR_EMPR = ?";
            PreparedStatement se = (PreparedStatement) connection.prepareStatement(SQL);
            se.setInt(1, id);
            se.executeUpdate();
            se.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao remover SetorEmpresa em JDBCSetorEmpresaDAO", ex);
        }
       
    }

    @Override
    public List<SetorEmpresa> listar() {
       List<SetorEmpresa> setoresEmpresa = new ArrayList<>();
       try {
            String SQL = "select * from tb_setor_empr";
            PreparedStatement se = (PreparedStatement) connection.prepareStatement(SQL);
            ResultSet rs = se.executeQuery();
            while(rs.next()){
                SetorEmpresa setorEmpresa = new SetorEmpresa();
                setorEmpresa.setIdSetorEmpr(rs.getInt("ID_SETOR_EMPR"));
                setorEmpresa.setNmSetorEmpr(rs.getString("NM_SETOR_EMPR"));
                setoresEmpresa.add(setorEmpresa);
            }
            se.close();
            rs.close();
            return setoresEmpresa;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar SetorEmpresa em JDBCSetorEmpresaDAO", ex);
        }
    }

    @Override
    public SetorEmpresa buscar(int id) {
        
        SetorEmpresa setorEmpresa = new SetorEmpresa();
        
        try {
            String SQL = "SELECT * FROM tb_setor_empr WHERE ID_SETOR_EMPR = ?";
            PreparedStatement se = (PreparedStatement) connection.prepareStatement(SQL);
            se.setInt(1, id);
            ResultSet rs = se.executeQuery();
            
            rs.next();
            setorEmpresa.setIdSetorEmpr(rs.getInt("ID_SETOR_EMPR"));
            setorEmpresa.setNmSetorEmpr(rs.getString("NM_SETOR_EMPR"));
            
            se.close();
            rs.close();
            
            return setorEmpresa;
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar o SetorEmpresa desejado em JDBCSetorEmpresaDAO", ex);
        }
    }

    @Override
    public void editar(SetorEmpresa setorEmpresa) {
        
        
        try {
            String SQL = "UPDATE tb_setor_empr SET NM_SETOR_EMPR=? where ID_SETOR_EMPR=? ";
            PreparedStatement se = (PreparedStatement) connection.prepareStatement(SQL);
            se.setString(1, setorEmpresa.getNmSetorEmpr());
            se.setInt(2, setorEmpresa.getIdSetorEmpr());
            
            se.executeUpdate();
            
            se.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao atualizar o SetorEmpresa desejado em JDBCSetorEmpresaDAO", ex);
        }
    }
    
}
