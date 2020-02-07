package mz.com.centropontoencontro.dao;

import java.util.List;

import mz.com.centropontoencontro.domain.EstudanteDesistencia;

public interface EstudanteDesistenciaDAO {
	void save(EstudanteDesistencia estudanteDesistencia);
	
	void update(EstudanteDesistencia estudanteDesistencia);
	
	void delete(Long id);
	
	EstudanteDesistencia findById(Long id);
	
	List<EstudanteDesistencia> findAll();

}
