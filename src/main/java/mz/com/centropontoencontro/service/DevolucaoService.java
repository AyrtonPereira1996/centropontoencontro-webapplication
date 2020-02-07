package mz.com.centropontoencontro.service;

import java.util.List;

import mz.com.centropontoencontro.domain.Devolucao;

public interface DevolucaoService {
	void salvar(Devolucao devolucao);

	void editar(Devolucao devolucao);

	void delete(Long id);

	Devolucao pesquisarPorId(Long id);

	List<Devolucao> pesquisarTodos();
	
	Long obterTotalDevolucao();
	
	List<Devolucao> pesquisarTodosDesc();

}
