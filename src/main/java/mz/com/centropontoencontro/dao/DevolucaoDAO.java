package mz.com.centropontoencontro.dao;

import java.util.List;

import mz.com.centropontoencontro.domain.Devolucao;

public interface DevolucaoDAO {
	void save(Devolucao devolucao);

	void update(Devolucao devolucao);

	void delete(Long id);

	Devolucao findById(Long id);

	List<Devolucao> findAll();
	
	Long getTotalDevolucao();
	
	List<Devolucao> findAllDesc();
}
