package mz.com.centropontoencontro.service;

import java.util.List;

import mz.com.centropontoencontro.domain.Curso;

public interface CursoService {
	void salvar(Curso curso);

	void editar(Curso curso);

	void excluir(Long id);

	Curso pesquisarPorId(Long id);

	List<Curso> pesquisarTodos();
	
	boolean cursoTemEstudantes(Long id);
	
	boolean cursoTemPreEstudantes(Long id);
	
	boolean cursoTemFormador(Long id);
	
	Long obterTotalCursos();
	
}
