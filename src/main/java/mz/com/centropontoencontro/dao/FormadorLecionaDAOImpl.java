package mz.com.centropontoencontro.dao;

import org.springframework.stereotype.Repository;

import mz.com.centropontoencontro.domain.FormadorLeciona;

@Repository
public class FormadorLecionaDAOImpl extends AbstractDAO<FormadorLeciona> implements FormadorLecionaDAO  {

	@Override
	public Long getTotalFormadoresTeaching() {
	
		return createSingleResultQueryJpql("Select count(f) from FormadorLeciona as f");
	}

}
