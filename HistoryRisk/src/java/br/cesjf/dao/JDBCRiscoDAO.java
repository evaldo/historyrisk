package br.cesjf.dao;

import br.cesjf.classes.CategoriaRisco;
import br.cesjf.classes.FaixaProbabilidade;
import br.cesjf.classes.NivelImpacto;
import br.cesjf.classes.Projeto;
import br.cesjf.classes.Risco;
import br.cesjf.util.ConnectionFactory;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCRiscoDAO implements RiscoDAO {

    Connection connection;

    public JDBCRiscoDAO() {
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void inserir(Risco risco) {

        try {
            String SQL = "INSERT INTO tb_hrsk_risco (ID_HRSK_RISCO, ID_FAIXA_PROB, ID_CATG_RISCO, ID_NIVEL_IPCTO, ID_HRSK_PRJT, VL_CUSTO_ESPRD_RISCO_NGTV, DS_RISCO, VL_CUSTO_ESTMD_RISCO, VL_CUSTO_ESPRD_RISCO_PSTV, DT_INCS_RGST_RISCO, DT_ALTR_RGST_RISCO) VALUES"
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement rsc = (PreparedStatement) connection.prepareStatement(SQL);

            rsc.setInt(1, risco.getIdHrskRisco());
            rsc.setInt(2, risco.getFaixaProbabilidade().getIdFaixaProb());
            rsc.setInt(3, risco.getCategoriaRisco().getIdCategoriaRisco());
            rsc.setInt(4, risco.getNivelImpacto().getIdNivelIpcto());
            rsc.setInt(5, risco.getProjeto().getIdHrskprjt());
            rsc.setDouble(6, risco.getVlCustoEsprdRiscoNgtv());
            rsc.setString(7, risco.getDsRisco());
            rsc.setDouble(8, risco.getVlCustoEstmdRisco());
            rsc.setDouble(9, risco.getVlCustoEsprdRiscoPstv());
            rsc.setDate(10, new java.sql.Date(risco.getDtlncsRgstRisco().getTime()));
            rsc.setDate(11, new java.sql.Date(risco.getDtAltrRgstRisco().getTime()));

            rsc.executeUpdate();
            rsc.close();

        } catch (SQLException ex) {
            Logger.getLogger(JDBCProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao inserir Risco em JDBCRiscoDAO.", ex);
        }
    }

    @Override
    public void remover(int id) {
        
        try {
            String SQL = "DELETE FROM tb_hrsk_risco WHERE ID_HRSK_RISCO=?";
            PreparedStatement se = (PreparedStatement) connection.prepareStatement(SQL);
            se.setInt(1, id);
            se.executeUpdate();
            se.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao remover Risco em JDBCRiscoDAO", ex);
        }
    }

    @Override
    public List<Risco> listar() {
        List<Risco> riscos = new ArrayList<>();
        try {
            String SQL = "select * from tb_hrsk_risco";
            PreparedStatement rsc = (PreparedStatement) connection.prepareStatement(SQL);
            ResultSet rs = rsc.executeQuery();
            while (rs.next()) {
                Risco risco = new Risco();
                risco.setIdHrskRisco(rs.getInt("ID_HRSK_RISCO"));

                JDBCFaixaProbabilidadeDAO fp = new JDBCFaixaProbabilidadeDAO();
                FaixaProbabilidade faixaProbabilidade = fp.buscar(rs.getInt("ID_FAIXA_PROB"));
                risco.setFaixaProbabilidade(faixaProbabilidade);

                JDBCCategoriaRiscoDAO ctgr = new JDBCCategoriaRiscoDAO();
                CategoriaRisco categoriaRisco = ctgr.buscar(rs.getInt("ID_CATG_RISCO"));
                risco.setCategoriaRisco(categoriaRisco);

                JDBCNivelImpactoDAO nvlipcto = new JDBCNivelImpactoDAO();
                NivelImpacto nivelImpacto = nvlipcto.buscar(rs.getInt("ID_NIVEL_IPCTO"));
                risco.setNivelImpacto(nivelImpacto);

                JDBCProjetoDAO prjt = new JDBCProjetoDAO();
                Projeto projeto = prjt.buscar(rs.getInt("ID_HRSK_PRJT"));
                risco.setProjeto(projeto);

                risco.setVlCustoEsprdRiscoNgtv(rs.getDouble("VL_CUSTO_ESPRD_RISCO_NGTV"));
                risco.setDsRisco(rs.getString("DS_RISCO"));
                risco.setVlCustoEstmdRisco(rs.getDouble("VL_CUSTO_ESTMD_RISCO"));
                risco.setVlCustoEsprdRiscoPstv(rs.getDouble("VL_CUSTO_ESPRD_RISCO_PSTV"));
                risco.setDtlncsRgstRisco(rs.getDate("DT_INCS_RGST_RISCO"));
                risco.setDtAltrRgstRisco(rs.getDate("DT_ALTR_RGST_RISCO"));
                riscos.add(risco);
            }
            rsc.close();
            rs.close();
            return riscos;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCRiscoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar Riscos em JDBCRiscoDAO", ex);
        }
    }

    @Override
    public Risco buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Risco risco) {

        try {
            String SQL = "UPDATE tb_hrsk_risco SET ID_FAIXA_PROB=?, ID_CATG_RISCO=?, ID_NIVEL_IPCTO=?, ID_HRSK_PRJT=?, VL_CUSTO_ESPRD_RISCO_NGTV=?, DS_RISCO=?, VL_CUSTO_ESTMD_RISCO=?, VL_CUSTO_ESPRD_RISCO_PSTV=?, DT_INCS_RGST_RISCO=?, DT_ALTR_RGST_RISCO=? where ID_HRSK_RISCO=?";
            PreparedStatement rsc = (PreparedStatement) connection.prepareStatement(SQL);

            rsc.setInt(1, risco.getFaixaProbabilidade().getIdFaixaProb());
            rsc.setInt(2, risco.getCategoriaRisco().getIdCategoriaRisco());
            rsc.setInt(3, risco.getNivelImpacto().getIdNivelIpcto());
            rsc.setInt(4, risco.getProjeto().getIdHrskprjt());
            rsc.setDouble(5, risco.getVlCustoEsprdRiscoNgtv());
            rsc.setString(6, risco.getDsRisco());
            rsc.setDouble(7, risco.getVlCustoEstmdRisco());
            rsc.setDouble(8, risco.getVlCustoEsprdRiscoPstv());
            rsc.setDate(9, new java.sql.Date(risco.getDtlncsRgstRisco().getTime()));
            rsc.setDate(10, new java.sql.Date(risco.getDtAltrRgstRisco().getTime()));
            rsc.setInt(11, risco.getIdHrskRisco());

            rsc.executeUpdate();
            rsc.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao atualizar o Risco desejado em JDBCRiscoDAO", ex);
        }

    }

}
