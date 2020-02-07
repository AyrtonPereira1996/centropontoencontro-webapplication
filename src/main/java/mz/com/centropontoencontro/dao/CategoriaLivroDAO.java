package mz.com.centropontoencontro.dao;

import java.util.List;

import mz.com.centropontoencontro.domain.CategoriaLivro;

public interface CategoriaLivroDAO {
	
	void save(CategoriaLivro catLivro);

	void update(CategoriaLivro catLivro);

	void delete(Long id);

	CategoriaLivro findById(Long id);
	
	List<CategoriaLivro> findAll();
}
