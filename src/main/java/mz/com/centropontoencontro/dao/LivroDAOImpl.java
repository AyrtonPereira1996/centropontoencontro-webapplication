package mz.com.centropontoencontro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mz.com.centropontoencontro.domain.Livro;

@Repository
public class LivroDAOImpl extends AbstractDAO<Livro> implements LivroDAO  {

	@Override
	public List<Livro> findAllByNameQuantidade() {
		
		return createJpqlQuery("Select l from Livro as l order by l.numeropedidos desc");
	}

	@Override
	public Long getTotalLivros() {
		return createSingleResultQueryJpql("Select count(l) from Livro as l");
	}

}
