package mz.com.centropontoencontro.dao;

import org.springframework.stereotype.Repository;

import mz.com.centropontoencontro.domain.Curso;

@Repository
public class CursoDAOImpl extends AbstractDAO<Curso> implements CursoDAO {

	@Override
	public Long getTotalCurso() {

		return createSingleResultQueryJpql("Select count(c) from Curso as c");
	}

}
