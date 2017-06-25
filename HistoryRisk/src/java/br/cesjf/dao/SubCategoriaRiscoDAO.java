package br.cesjf.dao;

import br.cesjf.classes.SubCategoriaRisco;
import java.util.List;

public interface SubCategoriaRiscoDAO {
    
    public void inserir(SubCategoriaRisco subCategoriaRisco);
    public void remover(int id);
    public List<SubCategoriaRisco> listar();
    public SubCategoriaRisco buscar(int idSubCatgRisco);
    public void editar(SubCategoriaRisco subCategoriaRisco);
    public List<SubCategoriaRisco> pesquisar(String pesq);
    public List<SubCategoriaRisco> getByCategoriaRisco(int idCategoriaRisco);
    
}
