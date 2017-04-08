package br.cesjf.util;

import br.cesjf.dao.CategoriaRiscoDAO;
import br.cesjf.dao.FaixaProbabilidadeDAO;
import br.cesjf.dao.JDBCCategoriaRiscoDAO;
import br.cesjf.dao.JDBCFaixaProbabilidadeDAO;
import br.cesjf.dao.JDBCNivelImpactoDAO;
import br.cesjf.dao.JDBCProjetoDAO;
import br.cesjf.dao.JDBCSetorEmpresaDAO;
import br.cesjf.dao.NivelImpactoDAO;
import br.cesjf.dao.ProjetoDAO;
import br.cesjf.dao.SetorEmpresaDAO;

public class DAOFactory {
    
    public static SetorEmpresaDAO createSetorEmpresaDAO(){
        return new JDBCSetorEmpresaDAO();
    }
    
    public static CategoriaRiscoDAO createCategoraiRiscoDAO(){
        return new JDBCCategoriaRiscoDAO();
    }
    
    public static FaixaProbabilidadeDAO createFaixaProbabilidadeDAO(){
        return new JDBCFaixaProbabilidadeDAO();
    }
    
    public static NivelImpactoDAO createNivelImpactoDAO(){
        return new JDBCNivelImpactoDAO();
    }
    
    public static ProjetoDAO createProjetoDAO(){
        return new JDBCProjetoDAO();
    }
    
}
