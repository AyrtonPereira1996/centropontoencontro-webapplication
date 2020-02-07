package mz.com.centropontoencontro.service;

import java.util.List;

import mz.com.centropontoencontro.domain.Utente;

public interface UtenteService {
	void salvar(Utente utente);

	void editar(Utente utente);

	void excluir(Long id);

	Utente pesquisarPorId(Long id);

	List<Utente> pesquisarTodos();
	
	boolean utenteTemEmprestimos(Long id);
	
	boolean utenteTemDevolucoes(Long id);
	
	boolean utenteTemAprovacoes(Long id);
	
	boolean utenteTemReprovacoes(Long id);
	
	boolean utenteTemDesistencias(Long id);
	
	boolean UtentePermitido(Long id);
	
	List<Utente> pesquisarUtenteNumeroEmprestimos();
	
	Long obterTotalUtentes();
	
	void interditarUtentes();
	
	

}
