package br.cesjf.dao;

import br.cesjf.classes.SetorEmpresa;
import java.util.List;

public interface SetorEmpresaDAO {
    
    public void inserir(SetorEmpresa setorEmpresa);
    public void remover(int id);
    public List<SetorEmpresa> listar();
    public SetorEmpresa buscar(int id);
    public void editar(SetorEmpresa setorEmpresa);
    public List<SetorEmpresa> pesquisar(String pesq);
    
}
