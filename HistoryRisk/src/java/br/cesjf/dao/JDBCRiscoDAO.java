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

public class JDBCRiscoDAO implements RiscoDAO{
    
    Connection connection;

    public JDBCRiscoDAO() {
        connection = ConnectionFactory.getConnection();
    }
    
    

    @Override
    public void inserir(Risco risco) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Risco> listar() {
        List<Risco> riscos = new ArrayList<>();
       try {
            String SQL = "select * from tb_hrsk_risco";
            PreparedStatement rsc = (PreparedStatement) connection.prepareStatement(SQL);
            ResultSet rs = rsc.executeQuery();
            while(rs.next()){
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
