package br.cesjf.dao;

import br.cesjf.classes.Projeto;
import br.cesjf.classes.SetorEmpresa;
import br.cesjf.util.ConnectionFactory;
import com.mysql.jdbc.Connection;
import java.util.Date;
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
        try {
            String SQL = "INSERT INTO tb_hrsk_prjt (ID_HRSK_PRJT, ID_SETOR_EMPR, DS_PRJT, DT_RGST_PRJT) VALUES" 
                    + "(?, ?, ?, ?)";
            PreparedStatement prjt = (PreparedStatement) connection.prepareStatement(SQL);
            
            prjt.setInt(1, projeto.getIdHrskprjt());
            
            prjt.setInt(2,  projeto.getSetorEmpresa().getIdSetorEmpr());
            prjt.setString(3, projeto.getDsPrjt());
            prjt.setDate(4, new java.sql.Date(projeto.getDtRgstPrjt().getTime()));
            
            prjt.executeUpdate();
            prjt.close();
            
        }catch (SQLException ex) {
             Logger.getLogger(JDBCProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
             throw new RuntimeException("Falha ao inserir Projeto em JDBCProjetoDAO.", ex);
        }
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
            Logger.getLogger(JDBCProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar Projetos em JDBCProjetoDAO", ex);
        }
    
    }

    @Override
    public Projeto buscar(int id) {
          Projeto projeto = new Projeto();
        
        try {
            String SQL = "SELECT * FROM tb_hrsk_prjt WHERE ID_HRSK_PRJT = ?";
            PreparedStatement prjt = (PreparedStatement) connection.prepareStatement(SQL);
            prjt.setInt(1, id);
            ResultSet rs = prjt.executeQuery();
            
            rs.next();
            
            projeto.setIdHrskprjt(rs.getInt("ID_HRSK_PRJT"));
            
            JDBCSetorEmpresaDAO ds = new JDBCSetorEmpresaDAO();
            SetorEmpresa setorEmpresa = ds.buscar(rs.getInt("ID_SETOR_EMPR"));
            projeto.setSetorEmpresa(setorEmpresa);
            
            projeto.setDsPrjt(rs.getString("DS_PRJT"));
            projeto.setDtRgstPrjt(rs.getDate("DT_RGST_PRJT"));

            prjt.close();
            rs.close();
            
            return projeto;
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar o Projeto desejado em JDBCProjetoDAO", ex);
        }
    }

    @Override
    public void editar(Projeto projeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
