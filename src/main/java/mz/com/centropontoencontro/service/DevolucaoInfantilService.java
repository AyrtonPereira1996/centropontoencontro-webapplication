package mz.com.centropontoencontro.service;

import java.util.List;

import mz.com.centropontoencontro.domain.DevolucaoInfantil;

public interface DevolucaoInfantilService {
	void salvar(DevolucaoInfantil devInfantil);

	void editar(DevolucaoInfantil devInfantil);

	void excluir(Long id);
	
	DevolucaoInfantil pesquisarPorId(Long id);
	
	List<DevolucaoInfantil> pesquisarTodos();
	
	Long obterTotalDevolucaoInfantil();
	
	List<DevolucaoInfantil> pesquisarTodosDesc();
	
}
