package mz.com.centropontoencontro.service;

import java.util.List;

import mz.com.centropontoencontro.domain.Livro;

public interface LivroService {
	void salvar(Livro livro);

	void editar(Livro livro);

	void excluir(Long id);

	Livro pesquisarPorId(Long id);
	
	List<Livro> pesquisarTodos();
	
	boolean livroTemEmprestimo(Long id);
	
	boolean livroTemDevolucoes(Long id);
	
	List<Livro> pesquisarLivroNumeropedidos();
	
	Long obterTotalLivros();

}
