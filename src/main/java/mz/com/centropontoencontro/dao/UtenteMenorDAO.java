package mz.com.centropontoencontro.dao;

import java.util.List;

import mz.com.centropontoencontro.domain.UtenteMenor;

public interface UtenteMenorDAO {
	void save(UtenteMenor utenteMenor);

	void update(UtenteMenor utenteMenor);

	void delete(Long id);

	UtenteMenor findById(Long id);

	List<UtenteMenor> findAll();
	
	List<UtenteMenor> findAllUtenteByNomeQuantidade();
	
	Long getTotalUtentesMenor();
	


}
