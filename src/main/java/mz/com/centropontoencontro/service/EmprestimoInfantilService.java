package mz.com.centropontoencontro.service;

import java.util.List;

import mz.com.centropontoencontro.domain.EmprestimoInfantil;

public interface EmprestimoInfantilService {
	void salvar(EmprestimoInfantil empInfantil);

	void editar(EmprestimoInfantil empInfantil);

	void excluir(Long id);

	EmprestimoInfantil pesquisarPorId(Long id);

	List<EmprestimoInfantil> pesquisarTodos();
	
	Long obterTotalEmprestimoInfantil();
	
	List<EmprestimoInfantil> pesquisarTodosDesc();
	
	
}
