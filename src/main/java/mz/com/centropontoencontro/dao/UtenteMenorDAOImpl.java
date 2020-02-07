package mz.com.centropontoencontro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mz.com.centropontoencontro.domain.UtenteMenor;

@Repository
public class UtenteMenorDAOImpl extends AbstractDAO<UtenteMenor> implements UtenteMenorDAO{

	@Override
	public List<UtenteMenor> findAllUtenteByNomeQuantidade() {
		
		return createJpqlQuery("Select u from UtenteMenor as u order by u.numeroEmprestimos desc");
	}

	@Override
	public Long getTotalUtentesMenor() {
		
		return createSingleResultQueryJpql("Select count(u) from UtenteMenor as u");
	}


}
