package mz.com.centropontoencontro.service;

import java.util.List;

import mz.com.centropontoencontro.domain.EstudanteDesistencia;

public interface EstudanteDesistenciaService {
	
	void salvar(EstudanteDesistencia estudanteDesistencia);
	
	void editar(EstudanteDesistencia estudanteDesistencia);
	
	void excluir(Long id);
	
	EstudanteDesistencia pesquisarPorId(Long id);
	
	List<EstudanteDesistencia> pesquisarTodos();
}
