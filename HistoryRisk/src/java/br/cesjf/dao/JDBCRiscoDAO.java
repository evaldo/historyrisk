package br.cesjf.dao;

import br.cesjf.classes.CategoriaRisco;
import br.cesjf.classes.FaixaProbabilidade;
import br.cesjf.classes.NivelImpacto;
import br.cesjf.classes.Projeto;
import br.cesjf.classes.Risco;
import br.cesjf.classes.SubCategoriaRisco;
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

public class JDBCRiscoDAO implements RiscoDAO {

    Connection connection;

    public JDBCRiscoDAO() {
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void inserir(Risco risco) {

        try {
            String SQL = "INSERT INTO tb_hrsk_risco (ID_FAIXA_PROB, NU_PERCT_PROB_RISCO, ID_CATG_RISCO, "
                    + "ID_SUBCATG_RISCO, ID_NIVEL_IPCTO, ID_HRSK_PRJT, DS_RISCO, "
                    + "VL_CUSTO_ESTMD_RISCO, IC_RISCO_OCRRD_PRJT, OB_RISCO_OCRRD_PRJT, NU_MATR_INCS, DT_INCS) VALUES"
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement rsc = (PreparedStatement) connection.prepareStatement(SQL);

            rsc.setInt(1, risco.getFaixaProbabilidade().getIdFaixaProb());
            rsc.setDouble(2, risco.getNuPerctProbRisco());
            rsc.setInt(3, risco.getCategoriaRisco().getIdCategoriaRisco());
            rsc.setInt(4, risco.getSubCategoriaRisco().getIdSubCatgRisco());
            rsc.setInt(5, risco.getNivelImpacto().getIdNivelIpcto());
            rsc.setInt(6, risco.getProjeto().getIdHrskprjt());
            rsc.setString(7, risco.getDsRisco());
            rsc.setDouble(8, risco.getVlCustoEstmdRisco());
            rsc.setString(9, risco.getIcRiscoOcrrdPrjt());
            rsc.setString(10, risco.getObRiscoOcrrdPrjt());
            rsc.setString(11, risco.getNuMatrIncs().getNuMatrIncs());
            rsc.setDate(12, new java.sql.Date(risco.getDtIncs().getTime()));

            rsc.executeUpdate();
            rsc.close();
            connection.close();

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
            connection.close();

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

                JDBCSubCategoriaRiscoDAO subctgr = new JDBCSubCategoriaRiscoDAO();
                SubCategoriaRisco subCategoriaRisco = subctgr.buscar(rs.getInt("ID_SUBCATG_RISCO"));
                risco.setSubCategoriaRisco(subCategoriaRisco);

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
                risco.setNuPerctProbRisco(rs.getDouble("NU_PERCT_PROB_RISCO"));
                risco.setObRiscoOcrrdPrjt(rs.getString("OB_RISCO_OCRRD_PRJT"));
                risco.setIcRiscoOcrrdPrjt(rs.getString("IC_RISCO_OCRRD_PRJT"));
                risco.setNuPerctProbRisco(rs.getDouble("NU_PERCT_PROB_RISCO"));
                risco.setObRiscoOcrrdPrjt(rs.getString("OB_RISCO_OCRRD_PRJT"));
                risco.setIcRiscoOcrrdPrjt(rs.getString("IC_RISCO_OCRRD_PRJT"));

                riscos.add(risco);
            }
            rsc.close();
            rs.close();
            connection.close();
            return riscos;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCRiscoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar Riscos em JDBCRiscoDAO", ex);
        }
    }

    @Override
    public Risco buscar(int id) {
        Risco risco = new Risco();

        try {
            String SQL = "SELECT * FROM tb_hrsk_risco WHERE ID_HRSK_RISCO = ?";
            PreparedStatement rsc = (PreparedStatement) connection.prepareStatement(SQL);
            rsc.setInt(1, id);
            ResultSet rs = rsc.executeQuery();

            rs.next();

            risco.setIdHrskRisco(rs.getInt("ID_HRSK_RISCO"));

            JDBCFaixaProbabilidadeDAO fp = new JDBCFaixaProbabilidadeDAO();
            FaixaProbabilidade faixaProbabilidade = fp.buscar(rs.getInt("ID_FAIXA_PROB"));
            risco.setFaixaProbabilidade(faixaProbabilidade);

            JDBCCategoriaRiscoDAO ctgr = new JDBCCategoriaRiscoDAO();
            CategoriaRisco categoriaRisco = ctgr.buscar(rs.getInt("ID_CATG_RISCO"));
            risco.setCategoriaRisco(categoriaRisco);

            JDBCSubCategoriaRiscoDAO subctgr = new JDBCSubCategoriaRiscoDAO();
            SubCategoriaRisco subCategoriaRisco = subctgr.buscar(rs.getInt("ID_SUBCATG_RISCO"));
            risco.setSubCategoriaRisco(subCategoriaRisco);

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

            JDBCUsuarioDAO usr = new JDBCUsuarioDAO();
            Usuario usuario = usr.buscar(rs.getString("NU_MATR_INCS"));
            risco.setNuMatrIncs(usuario);

            risco.setDtIncs(rs.getDate("DT_INCS"));
            risco.setNuPerctProbRisco(rs.getDouble("NU_PERCT_PROB_RISCO"));
            risco.setObRiscoOcrrdPrjt(rs.getString("OB_RISCO_OCRRD_PRJT"));
            risco.setIcRiscoOcrrdPrjt(rs.getString("IC_RISCO_OCRRD_PRJT"));

            rsc.close();
            rs.close();
            connection.close();

            return risco;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar o Projeto desejado em JDBCProjetoDAO", ex);
        }
    }

    @Override
    public void editar(Risco risco) {

        try {
            String SQL = "UPDATE tb_hrsk_risco SET ID_FAIXA_PROB=?, ID_CATG_RISCO=?, ID_NIVEL_IPCTO=?, ID_HRSK_PRJT=?, "
                    + "ID_SUBCATG_RISCO=?, DS_RISCO=?, NU_PERCT_PROB_RISCO=?, VL_CUSTO_ESTMD_RISCO=?, "
                    + "IC_RISCO_OCRRD_PRJT=?, OB_RISCO_OCRRD_PRJT=?, NU_MATR_ALTR=?, DT_ALTR=? where ID_HRSK_RISCO=?";
            PreparedStatement rsc = (PreparedStatement) connection.prepareStatement(SQL);

            rsc.setInt(1, risco.getFaixaProbabilidade().getIdFaixaProb());
            rsc.setInt(2, risco.getCategoriaRisco().getIdCategoriaRisco());
            rsc.setInt(3, risco.getNivelImpacto().getIdNivelIpcto());
            rsc.setInt(4, risco.getProjeto().getIdHrskprjt());
            rsc.setInt(5, risco.getSubCategoriaRisco().getIdSubCatgRisco());
            rsc.setString(6, risco.getDsRisco());
            rsc.setDouble(7, risco.getNuPerctProbRisco());
            rsc.setDouble(8, risco.getVlCustoEstmdRisco());
            rsc.setString(9, risco.getIcRiscoOcrrdPrjt());
            rsc.setString(10, risco.getObRiscoOcrrdPrjt());
            rsc.setString(11, risco.getNuMatrAltr().getNuMatrIncs());
            rsc.setDate(12, new java.sql.Date(risco.getDtAltr().getTime()));
            rsc.setInt(13, risco.getIdHrskRisco());

            rsc.executeUpdate();
            rsc.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao atualizar o Risco desejado em JDBCRiscoDAO", ex);
        }

    }

    @Override
    public List<Risco> getByProject(int idProjeto) {
        List<Risco> riscos = new ArrayList<>();
        try {
            String SQL = "select * from tb_hrsk_risco WHERE ID_HRSK_PRJT = ?";
            PreparedStatement rsc = (PreparedStatement) connection.prepareStatement(SQL);
            rsc.setInt(1, idProjeto);
            ResultSet rs = rsc.executeQuery();
            while (rs.next()) {
                Risco risco = new Risco();
                risco.setIdHrskRisco(rs.getInt("ID_HRSK_RISCO"));

                JDBCProjetoDAO prjt = new JDBCProjetoDAO();
                Projeto projeto = prjt.buscar(rs.getInt("ID_HRSK_PRJT"));
                risco.setProjeto(projeto);

                risco.setDsRisco(rs.getString("DS_RISCO"));
                risco.setVlCustoEsprdRiscoNgtv(rs.getDouble("VL_CUSTO_ESPRD_RISCO_NGTV"));
                risco.setVlCustoEsprdRiscoPstv(rs.getDouble("VL_CUSTO_ESPRD_RISCO_PSTV"));
                risco.setNuPerctProbRisco(rs.getDouble("NU_PERCT_PROB_RISCO"));

                riscos.add(risco);
            }
            rsc.close();
            rs.close();
            connection.close();

            return riscos;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCRiscoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar Riscos em JDBCRiscoDAO", ex);
        }

    }

    @Override
    public List<Risco> pesquisar(String pesq) {
        List<Risco> riscos = new ArrayList<>();
        try {
            String SQL = "select * from tb_hrsk_risco where DS_RISCO like ?";
            PreparedStatement rsc = (PreparedStatement) connection.prepareStatement(SQL);
            rsc.setString(1, "%" + pesq + "%");
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

                riscos.add(risco);
            }
            rsc.close();
            rs.close();
            connection.close();
            return riscos;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCRiscoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar Riscos em JDBCRiscoDAO", ex);
        }
    }

}
