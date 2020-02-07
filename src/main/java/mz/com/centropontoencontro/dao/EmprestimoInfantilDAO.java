package mz.com.centropontoencontro.dao;

import java.util.List;


import mz.com.centropontoencontro.domain.EmprestimoInfantil;

public interface EmprestimoInfantilDAO {
	void save(EmprestimoInfantil emprestimoInfantil);

	void update(EmprestimoInfantil emprestimoInfantil);

	void delete(Long id);

	EmprestimoInfantil findById(Long id);

	List<EmprestimoInfantil> findAll();
	
	Long getTotalEmprestimos();
	
	List<EmprestimoInfantil> findAllByDesc();

}
