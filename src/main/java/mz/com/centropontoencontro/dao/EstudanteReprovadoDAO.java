package mz.com.centropontoencontro.dao;

import java.util.List;

import mz.com.centropontoencontro.domain.EstudanteReprovado;

public interface EstudanteReprovadoDAO {

	void save(EstudanteReprovado estudanteReprovado);

	void update(EstudanteReprovado estudanteReprovado);

	void delete(Long id);

	EstudanteReprovado findById(Long id);

	List<EstudanteReprovado> findAll();

}
