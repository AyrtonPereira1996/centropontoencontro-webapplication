package mz.com.centropontoencontro.service;

import java.util.List;

import mz.com.centropontoencontro.domain.PreEstudante;

public interface PreEstudanteService {
	void salvar(PreEstudante preEstudante);

	void editar(PreEstudante preEstudante);

	void excluir(Long id);

	PreEstudante pesquisarPorID(Long id);

	List<PreEstudante> pesquisarTodos();
	
	void salvarConfirmacao(PreEstudante preEstudante);
}
