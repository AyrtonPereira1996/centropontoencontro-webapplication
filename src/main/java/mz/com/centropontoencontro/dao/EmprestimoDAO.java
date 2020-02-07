package mz.com.centropontoencontro.dao;

import java.util.List;

import mz.com.centropontoencontro.domain.Emprestimo;

public interface EmprestimoDAO {
	void save(Emprestimo emprestimo);

	void update(Emprestimo emprestimo);

	void delete(Long id);

	Emprestimo findById(Long id);

	List<Emprestimo> findAll();
	
	Long getTotalEmprestimos();
	
	List<Emprestimo> findAllDesc();
	
	
}
