package mz.com.centropontoencontro.dao;

import java.util.List;

import mz.com.centropontoencontro.domain.FormadorLeciona;

public interface FormadorLecionaDAO {
	void save(FormadorLeciona formadorleciona);

	void update(FormadorLeciona formadorleciona);

	void delete(Long id);

	FormadorLeciona findById(Long id);

	List<FormadorLeciona> findAll();
	
	Long getTotalFormadoresTeaching();
}
