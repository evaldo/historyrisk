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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                nivelImpacto.setIcNivelIpcto(rs.getString("IC_NIVEL_IPCTO"));
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
            nivelImpacto.setIcNivelIpcto(rs.getString("IC_NIVEL_IPCTO"));

            nvlipcto.close();
            rs.close();
            
            return nivelImpacto;
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCNivelImpactoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar o Nivel Impacto desejado em JDBCNivelImpactoDAO", ex);
        }
    }

    @Override
    public void editar(NivelImpacto setorEmpresa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
