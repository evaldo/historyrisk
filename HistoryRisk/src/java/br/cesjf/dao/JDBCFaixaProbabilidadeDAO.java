package br.cesjf.dao;

import br.cesjf.classes.FaixaProbabilidade;
import br.cesjf.util.ConnectionFactory;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JDBCFaixaProbabilidadeDAO implements FaixaProbabilidadeDAO {
    
    Connection connection;

    public JDBCFaixaProbabilidadeDAO() {
        connection = ConnectionFactory.getConnection();
    }
    
    

    @Override
    public void inserir(FaixaProbabilidade faixaProbabilidade) {
        
        try {
        String SQL = "INSERT INTO tb_hrsk_faixa_prob (ID_FAIXA_PROB, DS_FAIXA_PROB, NU_LMTE_INFR, NU_LMTE_SUPR) VALUES" 
                    + "(?, ?, ?, ?)";
            PreparedStatement se = (PreparedStatement) connection.prepareStatement(SQL);
            se.setInt(1, faixaProbabilidade.getIdFaixaProb());
            se.setString(2, faixaProbabilidade.getDsFaixaProb());
            se.setInt(3, faixaProbabilidade.getNuLmteInfr());
            se.setInt(4, faixaProbabilidade.getNuLmteSupr());
            
            se.executeUpdate();
            se.close();
        }catch (SQLException ex) {
             Logger.getLogger(JDBCFaixaProbabilidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
             throw new RuntimeException("Falha ao inserir Faixa Probabilidade em JDBCFaixaProbabilidadeDAO.", ex);
        }
    }

    @Override
    public void remover(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FaixaProbabilidade> listar() {
        List<FaixaProbabilidade> faixasProbabilidade = new ArrayList<>();
       try {
            String SQL = "select * from tb_hrsk_faixa_prob";
            PreparedStatement se = (PreparedStatement) connection.prepareStatement(SQL);
            ResultSet rs = se.executeQuery();
            while(rs.next()){
                FaixaProbabilidade faixaProbabilidade = new FaixaProbabilidade();
                faixaProbabilidade.setIdFaixaProb(rs.getInt("ID_FAIXA_PROB"));
                faixaProbabilidade.setDsFaixaProb(rs.getString("DS_FAIXA_PROB"));
                faixaProbabilidade.setNuLmteInfr(rs.getInt("NU_LMTE_INFR"));
                faixaProbabilidade.setNuLmteSupr(rs.getInt("NU_LMTE_SUPR"));
                faixasProbabilidade.add(faixaProbabilidade);
            }
            se.close();
            rs.close();
            return faixasProbabilidade;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar SetorEmpresa em JDBCSetorEmpresaDAO", ex);
        }
    }

    @Override
    public FaixaProbabilidade buscar(int id) {
       FaixaProbabilidade faixaProbabilidade = new FaixaProbabilidade();
        
        try {
            String SQL = "SELECT * FROM tb_hrsk_faixa_prob WHERE ID_FAIXA_PROB = ?";
            PreparedStatement fxpb = (PreparedStatement) connection.prepareStatement(SQL);
            fxpb.setInt(1, id);
            ResultSet rs = fxpb.executeQuery();
            
            rs.next();
            
            faixaProbabilidade.setIdFaixaProb(rs.getInt("ID_FAIXA_PROB"));
            faixaProbabilidade.setDsFaixaProb(rs.getString("DS_FAIXA_PROB"));
            faixaProbabilidade.setNuLmteInfr(rs.getInt("NU_LMTE_INFR"));
            faixaProbabilidade.setNuLmteSupr(rs.getInt("NU_LMTE_SUPR"));
            
            fxpb.close();
            rs.close();
            
            return faixaProbabilidade;
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCFaixaProbabilidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar o Faixa probabilidade desejado em JDBCFaixaProbabilidadeDAO", ex);
        }
    }

    @Override
    public void editar(FaixaProbabilidade faixaProbabilidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
