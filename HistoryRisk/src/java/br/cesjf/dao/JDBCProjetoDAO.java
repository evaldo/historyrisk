package br.cesjf.dao;

import br.cesjf.classes.Projeto;
import br.cesjf.classes.SetorEmpresa;
import br.cesjf.util.ConnectionFactory;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCProjetoDAO implements ProjetoDAO {
    
    Connection connection;

    public JDBCProjetoDAO() {
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void inserir(Projeto projeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Projeto> listar() {
        List<Projeto> projetos = new ArrayList<>();
       try {
            String SQL = "select * from tb_hrsk_prjt";
            PreparedStatement prjt = (PreparedStatement) connection.prepareStatement(SQL);
            ResultSet rs = prjt.executeQuery();
            while(rs.next()){
                Projeto projeto = new Projeto();
                projeto.setIdHrskprjt(rs.getInt("ID_HRSK_PRJT"));
                
                JDBCSetorEmpresaDAO ds = new JDBCSetorEmpresaDAO();
                SetorEmpresa setorEmpresa = ds.buscar(rs.getInt("ID_SETOR_EMPR"));
                
                projeto.setSetorEmpresa(setorEmpresa);
                projeto.setDsPrjt(rs.getString("DS_PRJT"));
                projeto.setDtRgstPrjt(rs.getDate("DT_RGST_PRJT"));
                projetos.add(projeto);
            }
            prjt.close();
            rs.close();
            return projetos;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar Projetos em JDBCProjetoDAO", ex);
        }
    
    }

    @Override
    public Projeto buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Projeto projeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
