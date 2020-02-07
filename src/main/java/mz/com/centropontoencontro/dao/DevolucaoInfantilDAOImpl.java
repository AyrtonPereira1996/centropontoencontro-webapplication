package mz.com.centropontoencontro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mz.com.centropontoencontro.domain.DevolucaoInfantil;

@Repository
public class DevolucaoInfantilDAOImpl extends AbstractDAO<DevolucaoInfantil> implements DevolucaoInfantilDAO {

	@Override
	public Long getTotalDevolucao() {
		
		return createSingleResultQueryJpql("Select count(d) from DevolucaoInfantil as d");
	}

	@Override
	public List<DevolucaoInfantil> findAllDesc() {

		return createJpqlQuery("Select d from DevolucaoInfantil as d order by d.dataRegisto desc");
	}

}
