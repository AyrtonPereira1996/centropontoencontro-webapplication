package mz.com.centropontoencontro.service;

import java.util.List;

import mz.com.centropontoencontro.domain.UtenteMenor;

public interface UtenteMenorService {
	void salvar(UtenteMenor utenteMenor);

	void editar(UtenteMenor utenteMenor);

	void excluir(Long id);

	UtenteMenor pesquisarPorId(Long id);

	List<UtenteMenor> pesquisarTodos();
	
	boolean utenteMenorTemEmprestimos(Long id);
	
	boolean utenteMenorTemDevolucoes(Long id);
	
	List<UtenteMenor> pesquisarPorNomeQuantidade();
	
	Long obterTotalUtentesMenores();
	
	

}
