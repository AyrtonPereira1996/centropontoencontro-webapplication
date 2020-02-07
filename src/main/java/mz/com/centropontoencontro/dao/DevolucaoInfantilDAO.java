package mz.com.centropontoencontro.dao;

import java.util.List;

import mz.com.centropontoencontro.domain.DevolucaoInfantil;

public interface DevolucaoInfantilDAO {
	void save(DevolucaoInfantil devolucaoInfantil);

	void update(DevolucaoInfantil devolucaoInfantil);

	void delete(Long id);

	DevolucaoInfantil findById(Long id);

	List<DevolucaoInfantil> findAll();
	
	Long getTotalDevolucao();
	
	List<DevolucaoInfantil> findAllDesc();

}
