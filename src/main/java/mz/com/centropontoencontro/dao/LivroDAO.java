package mz.com.centropontoencontro.dao;

import java.util.List;

import mz.com.centropontoencontro.domain.Livro;

public interface LivroDAO {
	void save(Livro livro);

	void update(Livro livro);

	void delete(Long id);

	Livro findById(Long id);

	List<Livro> findAll();
	
	List<Livro> findAllByNameQuantidade();
	
	Long getTotalLivros();
}
