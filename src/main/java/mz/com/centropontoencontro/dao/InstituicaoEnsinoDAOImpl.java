package mz.com.centropontoencontro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mz.com.centropontoencontro.domain.InstituicaoEnsino;

@Repository
public class InstituicaoEnsinoDAOImpl extends AbstractDAO<InstituicaoEnsino> implements InstituicaoEnsinoDAO{

	@Override
	public List<InstituicaoEnsino> findAllInstituicaoEnsinoInfantil() {
		return createJpqlQuery("Select i from InstituicaoEnsino as i where i.tipo='Infantil' order by i.id asc ");
	}

	@Override
	public List<InstituicaoEnsino> FindAllInstituicaoEnsino() {
		return createJpqlQuery("Select i from InstituicaoEnsino as i where i.tipo='Não infantil' order by i.id asc ");
	}

	@Override
	public Long getTotalInstituicaoEnsino() {
		return createSingleResultQueryJpql("Select count(i) from InstituicaoEnsino as i where i.tipo='Não Infantil'");
	}

	@Override
	public Long getTotalIntituicaoEnsinoInfantil() {
		return createSingleResultQueryJpql("Select count(i) from InstituicaoEnsino as i where i.tipo='Infantil'");
	}



}
