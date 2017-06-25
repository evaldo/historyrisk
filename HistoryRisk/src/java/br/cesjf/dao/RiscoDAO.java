package br.cesjf.dao;

import br.cesjf.classes.Risco;
import java.util.List;

public interface RiscoDAO {
    
    public void inserir(Risco risco);
    public void remover(int id);
    public List<Risco> listar();
    public Risco buscar(int id);
    public void editar(Risco risco);
    public List<Risco> getByProject(int idProjeto);
    public List<Risco> pesquisar(String pesq);
    
}
