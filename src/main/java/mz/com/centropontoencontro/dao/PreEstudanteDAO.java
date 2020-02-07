package mz.com.centropontoencontro.dao;

import java.util.List;

import mz.com.centropontoencontro.domain.PreEstudante;

public interface PreEstudanteDAO {
	void save(PreEstudante preestudante);

	void update(PreEstudante preestudante);

	void delete(Long id);

	PreEstudante findById(Long id);

	List<PreEstudante> findAll();
	
	
	
}
