package br.cesjf.dao;

import br.cesjf.classes.Projeto;
import java.util.List;

public interface ProjetoDAO {
    
    public void inserir(Projeto projeto);
    public void remover(int id);
    public List<Projeto> listar();
    public Projeto buscar(int id);
    public void editar(Projeto projeto);
    public List<Projeto> pesquisar(String pesq);
    
}
