package br.cesjf.dao;

import br.cesjf.classes.CategoriaRisco;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CategoriaRisco> listar() {
               List<CategoriaRisco> setoresEmpresa = new ArrayList<>();
       try {
            String SQL = "select * from tb_hrsk_catg_risco";
            PreparedStatement se = (PreparedStatement) connection.prepareStatement(SQL);
            ResultSet rs = se.executeQuery();
            while(rs.next()){
                CategoriaRisco categoriaRisco = new CategoriaRisco();
                categoriaRisco.setIdCategoriaRisco(rs.getInt("ID_CATG_RISCO"));
                categoriaRisco.setDsCategoriaRisco(rs.getString("DS_CATG_RISCO"));
                setoresEmpresa.add(categoriaRisco);
            }
            se.close();
            rs.close();
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
            
            return categoriaRisco;
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar o SetorEmpresa desejado em JDBCSetorEmpresaDAO", ex);
        }
    }

    @Override
    public void editar(CategoriaRisco categoriaRisco) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
