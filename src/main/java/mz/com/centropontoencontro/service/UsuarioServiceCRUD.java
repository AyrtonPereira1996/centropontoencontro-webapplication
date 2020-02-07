package mz.com.centropontoencontro.service;

import java.util.List;

import mz.com.centropontoencontro.domain.Usuario;

public interface UsuarioServiceCRUD {

	void salvar(Usuario usuario);

	void editar(Usuario usuario);

	void excluir(Long id);

	Usuario pesquisarPorId(Long id);

	List<Usuario> pesquisarTodos();
	
	String obterSenhaUsuario();

}
