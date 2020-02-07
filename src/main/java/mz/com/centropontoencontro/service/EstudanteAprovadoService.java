package mz.com.centropontoencontro.service;

import java.util.List;

import mz.com.centropontoencontro.domain.EstudanteAprovado;

public interface EstudanteAprovadoService {

	void salvar(EstudanteAprovado estudanteAprovado);

	void editar(EstudanteAprovado estudanteAprovado);

	void excluir(Long id);

	EstudanteAprovado pesquisarPorId(Long id);

	List<EstudanteAprovado> pesquisarTodos();
}
