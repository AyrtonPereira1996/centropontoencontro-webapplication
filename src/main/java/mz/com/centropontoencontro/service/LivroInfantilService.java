package mz.com.centropontoencontro.service;

import java.util.List;

import mz.com.centropontoencontro.domain.LivroInfantil;

public interface LivroInfantilService {
	void salvar(LivroInfantil livInfantil);

	void editar(LivroInfantil livInfantil);

	void excluir(Long id);

	LivroInfantil pesquisarPorId(Long id);

	List<LivroInfantil> pesquisarTodos();
	
	boolean livroTemEmprestimos(Long id);
	
	boolean livroTemDevolucoes(Long id);
	
	List<LivroInfantil> pesquisarLivroNumeroPedidos();
	
	Long obterTotalLivrosInfantis();
	
}
