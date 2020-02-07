package mz.com.centropontoencontro.dao;

import java.util.List;

import mz.com.centropontoencontro.domain.InstituicaoEnsino;

public interface InstituicaoEnsinoDAO {
	void save(InstituicaoEnsino insEnsino);

	void update(InstituicaoEnsino insEnsino);

	void delete(Long id);
	
	InstituicaoEnsino findById(Long id);
	
	List<InstituicaoEnsino> findAll();
	
	List<InstituicaoEnsino> findAllInstituicaoEnsinoInfantil();
	
	List<InstituicaoEnsino> FindAllInstituicaoEnsino();
	
	Long getTotalInstituicaoEnsino();
	
	Long getTotalIntituicaoEnsinoInfantil();

}
