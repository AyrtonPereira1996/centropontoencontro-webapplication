package mz.com.centropontoencontro.dao;


import org.springframework.stereotype.Repository;

import mz.com.centropontoencontro.domain.Formador;

@Repository
public class FormadorDAOImpl extends AbstractDAO<Formador> implements FormadorDAO {
	
	
	@Override
	public Long getTotalFormadores() {
		return createSingleResultQueryJpql("Select count(f) from Formador as f") ;
	}

}
