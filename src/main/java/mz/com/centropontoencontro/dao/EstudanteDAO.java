package mz.com.centropontoencontro.dao;

import java.util.List;

import mz.com.centropontoencontro.domain.Estudante;

public interface EstudanteDAO {
	
	void save(Estudante estudante);

	void update(Estudante estudante);

	void delete(Long id);

	Estudante findById(Long id);

	List<Estudante> findAll();

}
