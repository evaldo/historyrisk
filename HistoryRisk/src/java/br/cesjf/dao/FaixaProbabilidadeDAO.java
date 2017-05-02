package br.cesjf.dao;

import br.cesjf.classes.FaixaProbabilidade;
import java.util.List;

public interface FaixaProbabilidadeDAO {
    
    public void inserir(FaixaProbabilidade faixaProbabilidade);
    public void remover(int id);
    public List<FaixaProbabilidade> listar();
    public FaixaProbabilidade buscar(int id);
    public void editar(FaixaProbabilidade faixaProbabilidade);
}
