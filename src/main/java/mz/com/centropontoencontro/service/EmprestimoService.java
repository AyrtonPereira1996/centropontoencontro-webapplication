package mz.com.centropontoencontro.service;

import java.util.List;

import mz.com.centropontoencontro.domain.Emprestimo;

public interface EmprestimoService {
	void salvar(Emprestimo emprestimo);

	void editar(Emprestimo emprestimo);

	void excluir(Long id);

	Emprestimo pesquisarPorId(Long id);

	List<Emprestimo> pesquisarTodos();
	
	Long obterTotalEmprestimo();
	
	List<Emprestimo> pesquisarTodosDesc();
	



}
