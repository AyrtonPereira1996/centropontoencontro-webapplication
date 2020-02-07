package mz.com.centropontoencontro.dao;

import java.util.List;

import mz.com.centropontoencontro.domain.EstudanteAprovado;

public interface EstudanteAprovadoDAO {

	void save(EstudanteAprovado estudanteAprovado);

	void update(EstudanteAprovado estudanteAprovado);

	void delete(Long id);

	EstudanteAprovado findById(Long id);

	List<EstudanteAprovado> findAll();
}
