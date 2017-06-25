package br.cesjf.dao;

import br.cesjf.classes.FaixaProbabilidade;
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

public class JDBCFaixaProbabilidadeDAO implements FaixaProbabilidadeDAO {

    Connection connection;

    public JDBCFaixaProbabilidadeDAO() {
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void inserir(FaixaProbabilidade faixaProbabilidade) {

        try {
            String SQL = "INSERT INTO tb_hrsk_faixa_prob (DS_FAIXA_PROB, NU_LMTE_INFR, NU_LMTE_SUPR, NU_MATR_INCS, DT_INCS) VALUES"
                    + "(?, ?, ?, ?, ?)";
            PreparedStatement se = (PreparedStatement) connection.prepareStatement(SQL);
            se.setString(1, faixaProbabilidade.getDsFaixaProb());
            se.setInt(2, faixaProbabilidade.getNuLmteInfr());
            se.setInt(3, faixaProbabilidade.getNuLmteSupr());
            se.setString(4, faixaProbabilidade.getNuMatrIncs().getNuMatrIncs());
            se.setDate(5, new java.sql.Date(faixaProbabilidade.getDtIncs().getTime()));

            se.executeUpdate();
            se.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCFaixaProbabilidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao inserir Faixa Probabilidade em JDBCFaixaProbabilidadeDAO.", ex);
        }
    }

    @Override
    public void remover(int id) {
        try {
            String SQL = "DELETE FROM tb_hrsk_faixa_prob WHERE ID_FAIXA_PROB = ?";
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
    public List<FaixaProbabilidade> listar() {
        List<FaixaProbabilidade> faixasProbabilidade = new ArrayList<>();
        try {
            String SQL = "select * from tb_hrsk_faixa_prob";
            PreparedStatement se = (PreparedStatement) connection.prepareStatement(SQL);
            ResultSet rs = se.executeQuery();
            while (rs.next()) {
                FaixaProbabilidade faixaProbabilidade = new FaixaProbabilidade();
                faixaProbabilidade.setIdFaixaProb(rs.getInt("ID_FAIXA_PROB"));
                faixaProbabilidade.setDsFaixaProb(rs.getString("DS_FAIXA_PROB"));
                faixaProbabilidade.setNuLmteInfr(rs.getInt("NU_LMTE_INFR"));
                faixaProbabilidade.setNuLmteSupr(rs.getInt("NU_LMTE_SUPR"));

                faixasProbabilidade.add(faixaProbabilidade);
            }
            se.close();
            rs.close();
            connection.close();
            return faixasProbabilidade;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar Faixa Probabilidade em JDBCFaixaProbabilidadeDAO", ex);
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
            connection.close();

            return faixaProbabilidade;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCFaixaProbabilidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar o Faixa probabilidade desejado em JDBCFaixaProbabilidadeDAO", ex);
        }
    }

    @Override
    public void editar(FaixaProbabilidade faixaProbabilidade) {

        try {
            String SQL = "UPDATE tb_hrsk_faixa_prob SET DS_FAIXA_PROB=?, NU_LMTE_INFR=?, NU_LMTE_SUPR=?, NU_MATR_ALTR=?, DT_ALTR=? where ID_FAIXA_PROB=? ";
            PreparedStatement se = (PreparedStatement) connection.prepareStatement(SQL);
            se.setString(1, faixaProbabilidade.getDsFaixaProb());
            se.setInt(2, faixaProbabilidade.getNuLmteInfr());
            se.setInt(3, faixaProbabilidade.getNuLmteSupr());
            se.setString(4, faixaProbabilidade.getNuMatrAltr().getNuMatrIncs());
            se.setDate(5, new java.sql.Date(faixaProbabilidade.getDtAltr().getTime()));
            se.setInt(6, faixaProbabilidade.getIdFaixaProb());

            se.executeUpdate();
            se.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao atualizar a Faixa de Probabilidade desejado em JDBCFaixaProbabilidadeDAO", ex);
        }
    }

    @Override
    public List<FaixaProbabilidade> pesquisar(String pesq) {
        List<FaixaProbabilidade> faixasProbabilidade = new ArrayList<>();
        try {
            String SQL = "select * from tb_hrsk_faixa_prob where DS_FAIXA_PROB like ? ";
            PreparedStatement fp = (PreparedStatement) connection.prepareStatement(SQL);
            fp.setString(1, "%" + pesq + "%");
            ResultSet rs = fp.executeQuery();
            while (rs.next()) {
                FaixaProbabilidade faixaProbabilidade = new FaixaProbabilidade();
                faixaProbabilidade.setIdFaixaProb(rs.getInt("ID_FAIXA_PROB"));
                faixaProbabilidade.setDsFaixaProb(rs.getString("DS_FAIXA_PROB"));
                faixaProbabilidade.setNuLmteInfr(rs.getInt("NU_LMTE_INFR"));
                faixaProbabilidade.setNuLmteSupr(rs.getInt("NU_LMTE_SUPR"));

                faixasProbabilidade.add(faixaProbabilidade);
            }
            fp.close();
            rs.close();
            connection.close();

            return faixasProbabilidade;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar Faixa Probabilidade em JDBCFaixaProbabilidadeDAO", ex);
        }
    }

    @Override
    public List<FaixaProbabilidade> getByFaixaProbabilidadeRisco(int nuPerctProbRisco) {
                List<FaixaProbabilidade> faixasProbabilidade = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM tb_hrsk_faixa_prob WHERE ? BETWEEN NU_LMTE_INFR and NU_LMTE_SUPR ";
            PreparedStatement fp = (PreparedStatement) connection.prepareStatement(SQL);
            fp.setInt(1, nuPerctProbRisco);
            ResultSet rs = fp.executeQuery();
            while (rs.next()) {
                FaixaProbabilidade faixaProbabilidade = new FaixaProbabilidade();
                faixaProbabilidade.setIdFaixaProb(rs.getInt("ID_FAIXA_PROB"));
                faixaProbabilidade.setDsFaixaProb(rs.getString("DS_FAIXA_PROB"));
                faixaProbabilidade.setNuLmteInfr(rs.getInt("NU_LMTE_INFR"));
                faixaProbabilidade.setNuLmteSupr(rs.getInt("NU_LMTE_SUPR"));

                faixasProbabilidade.add(faixaProbabilidade);
            }
            fp.close();
            rs.close();
            connection.close();

            return faixasProbabilidade;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar Faixa Probabilidade em JDBCFaixaProbabilidadeDAO", ex);
        }
    }
    
    

}
