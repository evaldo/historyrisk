package br.cesjf.dao;

import br.cesjf.classes.Usuario;
import java.util.List;

public interface UsuarioDAO {
    
    public void inserir(Usuario usuario);
    public void remover(int id);
    public List<Usuario> listar();
    public Usuario buscar(String nuMatrIncs);
    public void editar(Usuario usuario);
    public Usuario buscarUsrPsw(Usuario usuario);
    
}
