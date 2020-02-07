package mz.com.centropontoencontro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mz.com.centropontoencontro.domain.Devolucao;

@Repository
public class DevolucaoDAOImpl extends AbstractDAO<Devolucao> implements DevolucaoDAO{

	@Override
	public Long getTotalDevolucao() {

		return createSingleResultQueryJpql("Select count(d) from Devolucao as d");
	}

	@Override
	public List<Devolucao> findAllDesc() {
		
		return createJpqlQuery("Select d from Devolucao as d order by d.dataRegisto desc");
	}
	
	
	
}
