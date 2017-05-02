
package br.cesjf.dao;

import br.cesjf.classes.CategoriaRisco;
import java.util.List;

public interface CategoriaRiscoDAO {
    
    public void inserir(CategoriaRisco categoriaRisco);
    public void remover(int id);
    public List<CategoriaRisco> listar();
    public CategoriaRisco buscar(int id);
    public void editar(CategoriaRisco categoriaRisco);
    
}
