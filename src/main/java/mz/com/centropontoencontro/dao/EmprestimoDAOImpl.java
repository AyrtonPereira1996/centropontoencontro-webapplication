package mz.com.centropontoencontro.dao;



import java.util.List;

import org.springframework.stereotype.Repository;

import mz.com.centropontoencontro.domain.Emprestimo;

@Repository
public class EmprestimoDAOImpl extends AbstractDAO<Emprestimo> implements EmprestimoDAO {

	@Override
	public Long getTotalEmprestimos() {
		
		return createSingleResultQueryJpql("Select count(e) from Emprestimo as e");
	}

	@Override
	public List<Emprestimo> findAllDesc() {
		
		return createJpqlQuery("Select e from Emprestimo as e order by e.dataRegisto desc");
	}

	


}
