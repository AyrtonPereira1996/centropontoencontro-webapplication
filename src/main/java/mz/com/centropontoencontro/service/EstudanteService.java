package mz.com.centropontoencontro.service;

import java.util.List;

import mz.com.centropontoencontro.domain.Estudante;


public interface EstudanteService {

	void salvar(Estudante estudante);

	void editar(Estudante estudante);

	void excluir(Long id);

	Estudante pesquisarPorId(Long id);

	List<Estudante> pesquisarTodos();

	
}
