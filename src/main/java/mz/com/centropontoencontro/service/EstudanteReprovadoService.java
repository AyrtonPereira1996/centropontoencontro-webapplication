package mz.com.centropontoencontro.service;

import java.util.List;

import mz.com.centropontoencontro.domain.EstudanteReprovado;

public interface EstudanteReprovadoService {
	
	void salvar(EstudanteReprovado estudanteReprovado);
	
	void editar(EstudanteReprovado estudanteReprovado);
	
	void excluir(Long id);
	
	EstudanteReprovado pesquisarPorId(Long id);

	List<EstudanteReprovado> pesquisarTodos();
}
