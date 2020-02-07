package mz.com.centropontoencontro.dao;

import java.util.List;

import mz.com.centropontoencontro.domain.Formador;

public interface FormadorDAO {
	void save(Formador formador);

	void update(Formador Formador);

	void delete(Long id);

	Formador findById(Long id);

	List<Formador> findAll();
	
	Long getTotalFormadores();
}
