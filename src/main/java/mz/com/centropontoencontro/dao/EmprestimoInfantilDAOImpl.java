package mz.com.centropontoencontro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mz.com.centropontoencontro.domain.EmprestimoInfantil;

@Repository
public class EmprestimoInfantilDAOImpl extends AbstractDAO<EmprestimoInfantil> implements EmprestimoInfantilDAO {

	@Override
	public Long getTotalEmprestimos() {
		
		return createSingleResultQueryJpql("Select count(e) from EmprestimoInfantil as e");
	}

	@Override
	public List<EmprestimoInfantil> findAllByDesc() {
	
		return createJpqlQuery("Select e from EmprestimoInfantil as e order by e.dataRegisto desc");
	}

}
