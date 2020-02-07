package mz.com.centropontoencontro.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import mz.com.centropontoencontro.domain.Utente;

@Repository
public class UtenteDAOImpl extends AbstractDAO<Utente> implements UtenteDAO {

	@Override
	public List<Utente> findAllUtenteByNumeroEmprestimos() {
		
		return createJpqlQuery("Select u from Utente as u order by u.numeroEmprestimos desc");
	}

	@Override
	public Long getTotalUtentes() {
		return createSingleResultQueryJpql("Select count(u) from Utente as u");
	}


	@Override
	public void interdict() {
		createQuery("update Utente set estado='Não permitido'");
		
	}

	
	
	


	
	

}
