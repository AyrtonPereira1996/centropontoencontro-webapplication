package mz.com.centropontoencontro.dao;

import java.util.List;

import mz.com.centropontoencontro.domain.LivroInfantil;

public interface LivroInfantilDAO {
	void save(LivroInfantil livroInfantil);

	void update(LivroInfantil livroInfantil);

	void delete(Long id);

	LivroInfantil findById(Long id);

	List<LivroInfantil> findAll();
	
	List<LivroInfantil> findAllByNameQuantidade();
	
	Long getTotalLivrosInfantis();
}
