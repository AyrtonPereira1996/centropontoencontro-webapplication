package mz.com.centropontoencontro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mz.com.centropontoencontro.domain.LivroInfantil;

@Repository
public class LivroInfantilDAOImpl extends AbstractDAO<LivroInfantil> implements LivroInfantilDAO {

	@Override
	public List<LivroInfantil> findAllByNameQuantidade() {
		
		return createJpqlQuery("Select l from LivroInfantil as l order by l.numeropedidos desc");
	}

	@Override
	public Long getTotalLivrosInfantis() {
		
		return createSingleResultQueryJpql("Select count(l) from LivroInfantil as l");
	}

}
