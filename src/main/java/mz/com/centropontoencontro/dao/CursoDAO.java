package mz.com.centropontoencontro.dao;

import java.util.List;

import mz.com.centropontoencontro.domain.Curso;

public interface CursoDAO {
	void save(Curso curso);

	void update(Curso curso);

	void delete(Long id);

	Curso findById(Long id);

	List<Curso> findAll();
	
	Long getTotalCurso();
}
