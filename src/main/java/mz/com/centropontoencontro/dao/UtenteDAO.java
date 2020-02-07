package mz.com.centropontoencontro.dao;

import java.util.List;

import mz.com.centropontoencontro.domain.Utente;

public interface UtenteDAO {
	void save(Utente utente);

	void update(Utente utente);

	void delete(Long id);

	Utente findById(Long id);

	List<Utente> findAll();
	
	List<Utente> findAllUtenteByNumeroEmprestimos();
	
	Long getTotalUtentes();
	
	void interdict();
	
}
