package br.cesjf.util;

import br.cesjf.dao.CategoriaRiscoDAO;
import br.cesjf.dao.FaixaProbabilidadeDAO;
import br.cesjf.dao.JDBCCategoriaRiscoDAO;
import br.cesjf.dao.JDBCFaixaProbabilidadeDAO;
import br.cesjf.dao.JDBCNivelImpactoDAO;
import br.cesjf.dao.JDBCProjetoDAO;
import br.cesjf.dao.JDBCRiscoDAO;
import br.cesjf.dao.JDBCSetorEmpresaDAO;
import br.cesjf.dao.JDBCSubCategoriaRiscoDAO;
import br.cesjf.dao.JDBCUsuarioDAO;
import br.cesjf.dao.NivelImpactoDAO;
import br.cesjf.dao.ProjetoDAO;
import br.cesjf.dao.RiscoDAO;
import br.cesjf.dao.SetorEmpresaDAO;
import br.cesjf.dao.SubCategoriaRiscoDAO;
import br.cesjf.dao.UsuarioDAO;

public class DAOFactory {

    public static SetorEmpresaDAO createSetorEmpresaDAO() {
        return new JDBCSetorEmpresaDAO();
    }

    public static CategoriaRiscoDAO createCategoraiRiscoDAO() {
        return new JDBCCategoriaRiscoDAO();
    }

    public static FaixaProbabilidadeDAO createFaixaProbabilidadeDAO() {
        return new JDBCFaixaProbabilidadeDAO();
    }

    public static NivelImpactoDAO createNivelImpactoDAO() {
        return new JDBCNivelImpactoDAO();
    }

    public static ProjetoDAO createProjetoDAO() {
        return new JDBCProjetoDAO();
    }

    public static RiscoDAO createRiscoDAO() {
        return new JDBCRiscoDAO();
    }

    public static UsuarioDAO createUsuarioDAO() {
        return new JDBCUsuarioDAO();
    }

    public static SubCategoriaRiscoDAO createSubCategoriaRiscoDAO() {
        return new JDBCSubCategoriaRiscoDAO();
    }

}
