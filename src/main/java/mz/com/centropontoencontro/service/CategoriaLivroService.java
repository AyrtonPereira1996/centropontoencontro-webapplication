package mz.com.centropontoencontro.service;

import java.util.List;

import mz.com.centropontoencontro.domain.CategoriaLivro;

public interface CategoriaLivroService {
	void salvar(CategoriaLivro catLivro);

	void editar(CategoriaLivro catLivro);

	void excluir(Long id);

	CategoriaLivro pesquisarPorId(Long id);

	List<CategoriaLivro> pesquisarTodos();
	
	boolean categoriaTemLivro(Long id);
	
	boolean categoriaInfantilTemLivro(Long id);
}
