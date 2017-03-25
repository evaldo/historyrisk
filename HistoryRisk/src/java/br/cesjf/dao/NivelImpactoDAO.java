package br.cesjf.dao;

import br.cesjf.classes.NivelImpacto;
import java.util.List;

public interface NivelImpactoDAO {
    
    public void inserir(NivelImpacto nivelImpacto);
    public void remover(int id);
    public List<NivelImpacto> listar();
    public NivelImpacto buscar(int id);
    public void editar(NivelImpacto setorEmpresa);
}
