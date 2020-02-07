package mz.com.centropontoencontro.service;

import java.util.List;

import mz.com.centropontoencontro.domain.Formador;

public interface FormadorService {
	void salvar(Formador formador);

	void editar(Formador formador);

	void excluir(Long id);

	Formador pesquisarPorId(Long id);

	List<Formador> pesquisarTodos();
	
	boolean formadorTemCurso (Long id);
	
	Long obterTotalFormadores();
	
	

}
