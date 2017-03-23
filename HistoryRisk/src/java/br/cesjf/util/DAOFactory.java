package br.cesjf.util;

import br.cesjf.dao.JDBCSetorEmpresaDAO;
import br.cesjf.dao.SetorEmpresaDAO;

public class DAOFactory {
    
    public static SetorEmpresaDAO createSetorEmpresaDAO(){
        return new JDBCSetorEmpresaDAO();
    }
    
}
