package br.cesjf.dao;

import br.cesjf.classes.Projeto;
import br.cesjf.classes.SetorEmpresa;
import br.cesjf.classes.Usuario;
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
            String SQL = "INSERT INTO tb_hrsk_prjt (ID_SETOR_EMPR, DS_PRJT, DT_RGST_PRJT, NU_MATR_INCS, DT_INCS) VALUES" 
                    + "(?, ?, ?, ?, ?)";
            PreparedStatement prjt = (PreparedStatement) connection.prepareStatement(SQL);

            prjt.setInt(1,  projeto.getSetorEmpresa().getIdSetorEmpr());
            prjt.setString(2, projeto.getDsPrjt());
            prjt.setDate(3, new java.sql.Date(projeto.getDtRgstPrjt().getTime()));
            prjt.setString(4, projeto.getNuMatrIncs().getNuMatrIncs());
            prjt.setDate(5, new java.sql.Date(projeto.getDtIncs().getTime()));
            
            prjt.executeUpdate();
            prjt.close();
            connection.close();
            
        }catch (SQLException ex) {
             Logger.getLogger(JDBCProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
             throw new RuntimeException("Falha ao inserir Projeto em JDBCProjetoDAO.", ex);
        }
    }

    @Override
    public void remover(int id) {
        
        try {
            String SQL = "DELETE FROM tb_hrsk_prjt WHERE ID_HRSK_PRJT=?";
            PreparedStatement se = (PreparedStatement) connection.prepareStatement(SQL);
            se.setInt(1, id);
            se.executeUpdate();
            se.close();
            connection.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao remover Projeto em JDBCProjetoDAO", ex);
        }
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
            connection.close();
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
            connection.close();
            
            return projeto;
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar o Projeto desejado em JDBCProjetoDAO", ex);
        }
    }

    @Override
    public void editar(Projeto projeto) {
        try {
            String SQL = "UPDATE tb_hrsk_prjt SET ID_SETOR_EMPR=?, DS_PRJT=?, DT_RGST_PRJT=?, NU_MATR_ALTR=?, DT_ALTR=? where ID_HRSK_PRJT=?";
            PreparedStatement prjt = (PreparedStatement) connection.prepareStatement(SQL);
            
            prjt.setInt(1,  projeto.getSetorEmpresa().getIdSetorEmpr());
            prjt.setString(2, projeto.getDsPrjt());
            prjt.setDate(3, new java.sql.Date(projeto.getDtRgstPrjt().getTime()));
            prjt.setString(4, projeto.getNuMatrAltr().getNuMatrIncs());
            prjt.setDate(5, new java.sql.Date(projeto.getDtAltr().getTime()));
            prjt.setInt(6, projeto.getIdHrskprjt());
            
 
            prjt.executeUpdate();
            prjt.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCSetorEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao atualizar o projeto desejado em JDBCProjetoDAO", ex);
        }
    }

    @Override
    public List<Projeto> pesquisar(String pesq) {
        List<Projeto> projetos = new ArrayList<>();
       try {
            String SQL = "select * from tb_hrsk_prjt where DS_PRJT like ?";
            PreparedStatement prjt = (PreparedStatement) connection.prepareStatement(SQL);
            prjt.setString(1, "%" + pesq + "%");
            ResultSet rs = prjt.executeQuery();
            while(rs.next()){
                Projeto projeto = new Projeto();
                projeto.setIdHrskprjt(rs.getInt("ID_HRSK_PRJT"));
                
                JDBCSetorEmpresaDAO ds = new JDBCSetorEmpresaDAO();
                SetorEmpresa setorEmpresa = ds.buscar(rs.getInt("ID_SETOR_EMPR"));
                projeto.setSetorEmpresa(setorEmpresa);
                
                projeto.setDsPrjt(rs.getString("DS_PRJT"));
                projeto.setDtRgstPrjt(rs.getDate("DT_RGST_PRJT"));
                
                JDBCUsuarioDAO usr = new JDBCUsuarioDAO();
                Usuario usuario = usr.buscar(rs.getString("NU_MATR_INCS"));
                projeto.setNuMatrIncs(usuario);
                
                projeto.setDtIncs(rs.getDate("DT_INCS"));
                
                projetos.add(projeto);
            }
            prjt.close();
            rs.close();
            connection.close();
            return projetos;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar Projetos em JDBCProjetoDAO", ex);
        }
    }
    
    

}
